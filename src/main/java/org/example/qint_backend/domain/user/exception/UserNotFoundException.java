package org.example.qint_backend.domain.user.exception;

import org.example.qint_backend.global.err.exception.ErrorCode;
import org.example.qint_backend.global.err.exception.QintException;

public class UserNotFoundException extends QintException {

    public static final QintException EXCEPTION = new UserNotFoundException();

    private UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
