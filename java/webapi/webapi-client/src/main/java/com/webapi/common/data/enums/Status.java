package com.webapi.common.data.enums;

public enum Status {
    INACTIVE("0"), ACTIVE("1");

    public final String value;

    Status(String value) {
        this.value = value;
    }
}
