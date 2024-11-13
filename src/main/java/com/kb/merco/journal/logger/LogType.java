package com.kb.merco.journal.logger;

import lombok.Getter;

public enum LogType
{

    TECH("TECH"), TEST("TEST"), BUSI("BUSI");

    @Getter
    private String value;

    private LogType(final String value)
    {
        this.value = value;
    }

}
