package com.kb.merco.journal.exception;

import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * this method used to create RecordNotFoundException as a custom exception .
 */
@Data
public final class RecordNotFoundException extends RuntimeException {

    @Getter
    private final HttpStatus errorcode;
    private String errormessage;
    private String advicemsg;

    /**
     * this method used to RecordNotFoundException for parameter .
     *
     * @param errormessage 1st parameter of this method .
     * @param cause        2nd parameter of this method .
     * @param errorcode    2nd parameter of this method .
     * @param advicemsg    3rd parameter of this method .
     */
    public RecordNotFoundException(final String errormessage, final Throwable cause, HttpStatus errorcode, String advicemsg) {
        super(errormessage, cause);
        this.errormessage = errormessage;
        this.errorcode = errorcode;
        this.advicemsg = advicemsg;
    }

    /**
     * this method used to RecordNotFoundException for parameter .
     *
     * @param errormessage 1st parameter of this method .
     * @param errorcode    2nd parameter of this method .
     * @param advicemsg    3rd parameter of this method .
     */
    public RecordNotFoundException(final String errormessage, HttpStatus errorcode, String advicemsg) {
        super(errormessage);
        this.errormessage = errormessage;
        this.errorcode = errorcode;
        this.advicemsg = advicemsg;
    }
}
