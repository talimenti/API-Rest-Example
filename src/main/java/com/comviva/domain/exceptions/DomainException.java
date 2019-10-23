package com.comviva.domain.exceptions;

public class DomainException extends Exception {
    private int code;
    public DomainException(String message) {
        super(message);
        code = -1;
    }
    public DomainException(int code, String message) {
        super(message);
        this.code = code;
    }
    public int getCode() {
        return code;
    }
}
