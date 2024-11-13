package com.kb.merco.journal.exception;

public final class JournalException extends RuntimeException {

    /**
     * this method used to SPException for parameter .
     *
     * @param errormessage 1st parameter of this method .
     * @param cause        2nd parameter of this method .
     */
    public JournalException(final String errormessage, final Throwable cause) {
        super(errormessage, cause);
    }

    /**
     * this method used to SPException for parameter .
     *
     * @param errormessage 1st parameter of this method .
     */
    public JournalException(final String errormessage) {
        super(errormessage);
    }
}
