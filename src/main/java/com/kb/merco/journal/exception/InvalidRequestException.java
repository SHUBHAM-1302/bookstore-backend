package com.kb.merco.journal.exception;

import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;
@Data
public final class InvalidRequestException extends RuntimeException
{

    /**
     * @param errormessage
     * @param cause
     */
    @Getter
    private final HttpStatus errorcode;
    private String errormessage;
    private String advicemsg;

    /**
     * this method used to  InvalidRequestException for parameter.
     *
     * @param errormessage 1st parameter of this methods .
     * @param cause        2nd parameter of this methods .
     * @param errorcode    3rd parameter of this methods .
     * @param advicemsg    4th parameter of this methods .
     */
    public InvalidRequestException(final String errormessage, final Throwable cause, HttpStatus errorcode, String advicemsg)
    {
        super(errormessage, cause);
        this.errormessage =errormessage ;
        this.errorcode = errorcode;
        this.advicemsg = advicemsg;
    }

    /**
     * this method used to  InvalidRequestException for parameter.
     *
     * @param errormessage 1st parameter of this methods .
     * @param errorcode    2nd parameter of this methods .
     * @param advicemsg    3rd parameter of this methods .
     */
    public InvalidRequestException(final String errormessage, HttpStatus errorcode, String advicemsg)
    {
        super(errormessage);
        this.errormessage =errormessage ;
        this.errorcode = errorcode;
        this.advicemsg = advicemsg;
    }
}
