package com.buddy.study.account.exception;

public class EmailDuplication extends RuntimeException{
    public EmailDuplication(String message){
        super(message);
    }
}
