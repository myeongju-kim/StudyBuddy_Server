package com.buddy.study.common.exception;

import com.buddy.study.common.dto.CommonResponse;
import com.buddy.study.common.service.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RequiredArgsConstructor
@ControllerAdvice("com.buddy.study.common")
public class CommonExceptionHandler {
    final private CommonService commonService;
    @ExceptionHandler(NameDuplication.class)
    public ResponseEntity<CommonResponse> NameDuplication(Exception e){
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(commonService.response("1001",e.getMessage(),null));
    }
}
