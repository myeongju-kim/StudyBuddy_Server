package com.buddy.study.common.exception;

import com.buddy.study.common.dto.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("com.buddy.study.common")
public class CommonExceptionHandler {
    private CommonResponse commonResponse=new CommonResponse();
    @ExceptionHandler(NameDuplication.class)
    public ResponseEntity<CommonResponse> NameDuplication(Exception e){
        commonResponse.setCode("1001");
        commonResponse.setMessage(e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(commonResponse);
    }
}
