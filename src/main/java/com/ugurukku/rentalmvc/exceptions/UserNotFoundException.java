package com.ugurukku.rentalmvc.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException() {
        super("Email or password is incorrect");
    }
}
