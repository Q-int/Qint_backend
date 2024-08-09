package org.example.qint_backend.domain.auth.exception;

import org.example.qint_backend.global.err.exception.ErrorCode;
import org.example.qint_backend.global.err.exception.QintException;

public class ExpiredTokenException extends QintException {

    public static final QintException EXCEPTION = new ExpiredTokenException();

    private ExpiredTokenException() {
        super(ErrorCode.INVALID_TOKEN_EXCEPTION);
    }
}
