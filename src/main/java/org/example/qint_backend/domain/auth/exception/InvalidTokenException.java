package org.example.qint_backend.domain.auth.exception;

import org.example.qint_backend.global.err.exception.ErrorCode;
import org.example.qint_backend.global.err.exception.QintException;

public class InvalidTokenException extends QintException {

    public static final QintException EXCEPTION = new InvalidTokenException();

    private InvalidTokenException() {
        super(ErrorCode.INVALID_TOKEN_EXCEPTION);
    }
}
