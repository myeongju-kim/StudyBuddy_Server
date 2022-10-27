package com.buddy.study.account.exception;

import com.buddy.study.common.dto.CommonResponse;
import com.buddy.study.common.service.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.Map;

@RequiredArgsConstructor
@ControllerAdvice("com.buddy.study.account")
public class AccountExceptionHandler {
    private final CommonService commonService;
    @ExceptionHandler(EmailDuplication.class)
    public ResponseEntity<CommonResponse> EmailDuplication(Exception e){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(commonService.response("1000",e.getMessage(),null));
    }
    @ExceptionHandler(LoginException.class)
    public ResponseEntity<CommonResponse> LoginFail(Exception e){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(commonService.response("2000",e.getMessage(),null));
    }
}
