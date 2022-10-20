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
    @ExceptionHandler(EmailDuplication.class)
    public ResponseEntity<CommonResponse> EmailDuplication(Exception e){
        CommonResponse commonResponse=new CommonResponse();
        commonResponse.setCode("1000");
        commonResponse.setMessage(e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(commonResponse);
    }
}
