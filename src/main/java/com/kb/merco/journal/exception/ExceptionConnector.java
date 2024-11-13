package com.kb.merco.journal.exception;



import com.kb.merco.journal.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@RestController
public final class ExceptionConnector extends ResponseEntityExceptionHandler {

    private static final int ERR_404 = 404;
    private static final int ERR_400 = 400;
    private static final int ERR_208 = 208;
    private static final String USE_VALID_PATCH_OPERATION = "Use a valid patch operation";
    private static final String PATCH_OPERATION_IS_INVALID = "The patch operation is invalid";
    private static final String REQUEST_INVALID = "Please provide valid request";
    private static final String RECORD_NOT_FOUND = "Record not found";
    private static final String USE_VALID_ID = "Use a valid id";
    private static final String INVALID_ID = "invalid id";
    private static final String DUPLICATE_RECORD = "Please enter record that is not present in database";
    private static final String DATABASE_NOT_CONNECT = "Database is not connected";

    /**
     * this method used to giving functionality to RecordNotFoundException .
     *
     * @param ex 1st parameter of this methods .
     * @return
     */
    @ExceptionHandler(RecordNotFoundException.class)
    public final ResponseEntity<ErrorDto> handleRecordNotFoundException(final RecordNotFoundException ex) {
        ErrorDto error = new ErrorDto();
        error.setErrorCode(ERR_404);
        error.setMessage(ex.getMessage());
        error.setAdvice(ex.getAdvicemsg());
        error.setRootCause(ex.toString());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    /**
     * this method used to giving functionality to handleDataBaseConnectivityException
     *
     * @param ex
     * @return ResponseEntity<ErrorDto>
     */
    @ExceptionHandler(DataBaseConnectivityException.class)
    public final ResponseEntity<ErrorDto> handleDataBaseConnectivityException(final DataBaseConnectivityException ex) {
        ErrorDto error = new ErrorDto();
        error.setErrorCode(504);
        error.setMessage(ex.getMessage());
        error.setAdvice(ex.getAdvicemsg());
        error.setRootCause(ex.toString());
        return new ResponseEntity<>(error, HttpStatus.GATEWAY_TIMEOUT);
    }

    /**
     * this method used to giving functionality to DuplicateRecordException .
     *
     * @param ex ex 1st parameter of this methods .
     * @return
     */
    @ExceptionHandler(DuplicateRecordException.class)
    public final ResponseEntity<ErrorDto> handleDuplicateRecordException(final DuplicateRecordException ex) {

        ErrorDto error = new ErrorDto();
        error.setErrorCode(ERR_208);
        error.setMessage(ex.getMessage());
        error.setAdvice(ex.getAdvicemsg());
        error.setRootCause(ex.toString());
        return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
    }

    /**
     * this method used to giving functionality to handleInvalidRequestException .
     *
     * @param ex ex 1st parameter of this methods .
     * @return
     */
    @ExceptionHandler(InvalidRequestException.class)
    public final ResponseEntity<ErrorDto> handleInvalidRequestException(final InvalidRequestException ex) {
        ErrorDto error = new ErrorDto();
        error.setErrorCode(ERR_400);
        error.setMessage(ex.getMessage());
        error.setAdvice(ex.getAdvicemsg());
        error.setRootCause(ex.toString());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
