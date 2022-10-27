package com.buddy.study.account.exception;

import com.buddy.study.common.dto.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

@ControllerAdvice("com.buddy.study.account")
public class AccountExceptionHandler {
    private CommonResponse commonResponse=new CommonResponse();
    @ExceptionHandler(EmailDuplication.class)
    public ResponseEntity<CommonResponse> EmailDuplication(Exception e){
        commonResponse.setCode("1000");
        commonResponse.setMessage(e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(commonResponse);
    }
    @ExceptionHandler(LoginException.class)
    public ResponseEntity<CommonResponse> LoginFail(Exception e){
        commonResponse.setCode("2000");
        commonResponse.setMessage(e.getMessage());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(commonResponse);
    }
}
