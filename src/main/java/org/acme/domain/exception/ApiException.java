package org.acme.domain.exception;

public class ApiException extends RuntimeException {

    private final int code;

    public ApiException(int code, String reason) {
        super(reason);
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
