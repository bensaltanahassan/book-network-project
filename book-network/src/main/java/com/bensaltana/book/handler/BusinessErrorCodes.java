package com.bensaltana.book.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum BusinessErrorCodes {

    NO_CODE(0, OK, "No Error"),
    INCORRECT_CURRENT_PASSWORD(300, BAD_REQUEST, "Incorrect current password"),
    NEW_PASSWORD_DOES_NOT_MATCH(301, BAD_REQUEST, "New password does not match"),
    ACCOUNT_LOCKED(302, FORBIDDEN, "Account locked"),
    ACCOUNT_DISABLED(303, FORBIDDEN, "Account disabled"),
    BAD_CREDENTIALS(304, UNAUTHORIZED, "Login and/or password are invalid"),
    USER_NOT_FOUND(305, NOT_FOUND, "User not found"),
    ;
    private final int code;
    private final HttpStatus httpStatus;
    private final String description;
}
