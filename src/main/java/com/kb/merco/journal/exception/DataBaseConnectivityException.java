package com.kb.merco.journal.exception;

import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;
@Data
public final class DataBaseConnectivityException extends RuntimeException {

    /**
     * @param errormessage
     * @param cause
     */
    @Getter
    private final HttpStatus errorcode;

    private String advicemsg;

    /**
     * This constructor used to intialize value
     *
     * @param errormessage 1st parameter of this methods .
     * @param cause        2nd parameter of this methods .
     * @param errorcode    3rd parameter of this methods .
     * @param advicemsg    4th parameter of this methods .
     */
    public DataBaseConnectivityException(final String errormessage, final Throwable cause, HttpStatus errorcode, String advicemsg) {
        super(errormessage, cause);
        this.errorcode = errorcode;
        this.advicemsg = advicemsg;
    }

    /**
     * This constructor used to intialize value.
     *
     * @param errormessage 1st parameter of this methods .
     * @param errorcode    2nd parameter of this methods .
     * @param advicemsg    3rd parameter of this methods .
     */
    public DataBaseConnectivityException(final String errormessage, HttpStatus errorcode, String advicemsg) {
        super(errormessage);
        this.errorcode = errorcode;
        this.advicemsg = advicemsg;
    }
}
