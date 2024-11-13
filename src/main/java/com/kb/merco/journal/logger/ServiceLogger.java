package com.kb.merco.journal.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Wrapper Class around Java logger
 *
 * @author Byre Gowda
 */
public final class ServiceLogger {
    private final Logger loggerInstance;
    private static final String TYPE_OF_LOGS = "typeOfLog";
    private static final String MESSAGE_CODE = "messageCode";

    public ServiceLogger(final Class<?> containerClass) {
        loggerInstance = LoggerFactory.getLogger(containerClass);
    }

    /**
     * Log a message at the DEBUG level.
     *
     * @param type the typeOfLog
     * @param arg0 the message String to be logged
     */
    public void debug(
            final LogType type,
            final String arg0) {
        loggerInstance.debug(arg0);
    }

    /**
     * Log a message at the DEBUG level according to the specified format and argument.
     *
     * @param type the typeOfLog
     * @param arg0 the format of the string to be logged
     * @param arg1 a list of 3 or more arguments
     */
    public void debug(
            final LogType type,

            final String arg0,
            final Object... arg1) {

        loggerInstance.debug(arg0, arg1);
    }

    /**
     * Log an exception (throwable) at the DEBUG level with an accompanying message.
     *
     * @param type the typeOfLog
     * @param arg0 the format of the string to be logged
     * @param arg1 the exception (throwable) to log
     */
    public void debug(
            final LogType type,

            final String arg0,
            final Throwable arg1) {

        loggerInstance.debug(arg0, arg1);
    }

    /**
     * Log a message at the ERROR level.
     *
     * @param type the typeOfLog
     * @param arg0 the message String to be logged
     */
    public void error(
            final LogType type,

            final String arg0) {

        loggerInstance.error(arg0);
    }

    /**
     * Log a message at the ERROR level according to the specified format and arguments.
     *
     * @param type the typeOfLog
     * @param arg0 the format of the string to be logged
     * @param arg1 a list of 3 or more arguments
     */
    public void error(
            final LogType type,

            final String arg0,
            final Object... arg1) {

        loggerInstance.error(arg0, arg1);
    }

    /**
     * Log an exception (throwable) at the ERROR level with an accompanying message.
     *
     * @param type the typeOfLog
     * @param arg0 the format of the string to be logged
     * @param arg1 the exception (throwable) to log
     */
    public void error(
            final LogType type,

            final String arg0,
            final Throwable arg1) {

        loggerInstance.error(arg0, arg1);
    }

    /**
     * Log a message at the INFO level.
     *
     * @param type the typeOfLog
     * @param arg0 the message String to be logged
     */
    public void info(
            final LogType type,

            final String arg0) {

        loggerInstance.info(arg0);
    }

    /**
     * Log a message at the INFO level according to the specified format and arguments.
     *
     * @param type the typeOfLog
     * @param arg0 the format of the string to be logged
     * @param arg1 a list of 3 or more arguments
     */
    public void info(
            final LogType type,

            final String arg0,
            final Object... arg1) {

        loggerInstance.info(arg0, arg1);
    }

    /**
     * Log an exception (throwable) at the INFO level with an accompanying message
     *
     * @param type the typeOfLog
     * @param arg0 the format of the string to be logged
     * @param arg1 the exception (throwable) to log
     */
    public void info(
            final LogType type,

            final String arg0,
            final Throwable arg1) {

        loggerInstance.info(arg0, arg1);
    }

    /**
     * Log a message at the TRACE level.
     *
     * @param type the typeOfLog
     * @param arg0 the message String to be logged
     */
    public void trace(
            final LogType type,

            final String arg0) {

        loggerInstance.trace(arg0);
    }

    /**
     * Log a message at the TRACE level according to the specified format and arguments.
     *
     * @param type the typeOfLog
     * @param arg0 the format of the string to be logged
     * @param arg1 a list of 3 or more arguments
     */
    public void trace(
            final LogType type,

            final String arg0,
            final Object... arg1) {

        loggerInstance.trace(arg0, arg1);
    }

    /**
     * Log an exception (throwable) at the TRACE level with an accompanying message.
     *
     * @param type the typeOfLog
     * @param arg0 the format of the string to be logged
     * @param arg1 the exception (throwable) to log
     */
    public void trace(
            final LogType type,

            final String arg0,
            final Throwable arg1) {

        loggerInstance.trace(arg0, arg1);
    }

    /**
     * Log a message at the WARN level according to the specified format and arguments.
     *
     * @param type the typeOfLog
     * @param arg0 the message String to be logged
     */
    public void warn(
            final LogType type,

            final String arg0) {

        loggerInstance.warn(arg0);
    }

    /**
     * Log a message at the WARN level according to the specified format and arguments.
     *
     * @param type the typeOfLog
     * @param arg0 the format of the string to be logged
     * @param arg1 a list of 3 or more arguments
     */
    public void warn(
            final LogType type,

            final String arg0,
            final Object... arg1) {

        loggerInstance.warn(arg0, arg1);
    }

    /**
     * Log a message at the WARN level according to the specified format * and arguments.
     *
     * @param type the typeOfLog
     * @param arg0 the format of the string to be logged
     * @param arg1 the exception (throwable) to log
     */
    public void warn(
            final LogType type,

            final String arg0,
            final Throwable arg1) {

        loggerInstance.warn(arg0, arg1);
    }


}