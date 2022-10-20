package com.buddy.study.account.dto;

import lombok.Data;

@Data
public class JoinRequest {
    private String nickname;
    private String email;
    private String password;
}
