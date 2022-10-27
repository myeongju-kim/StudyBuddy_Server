package com.buddy.study.common.dto;

import lombok.Data;

@Data
public class CommonResponse {
    private String code;
    private String message;
    private Object result;
}
