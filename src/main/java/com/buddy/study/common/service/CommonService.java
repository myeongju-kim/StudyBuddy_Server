package com.buddy.study.common.service;

import com.buddy.study.account.domain.Account;
import com.buddy.study.account.dto.JoinRequest;
import com.buddy.study.account.dto.LoginRequest;
import com.buddy.study.account.dto.LoginResponse;
import com.buddy.study.account.exception.EmailDuplication;
import com.buddy.study.account.exception.LoginException;
import com.buddy.study.account.repository.AccountRepository;
import com.buddy.study.common.dto.CommonResponse;
import com.buddy.study.common.exception.NameDuplication;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommonService {
    final private AccountRepository accountRepository;
    private CommonResponse commonResponse=new CommonResponse();
    public CommonResponse checkUser(String name){
        if(accountRepository.findByName(name)){
            throw new NameDuplication("닉네임이 중복되었습니다.");
        }
        commonResponse.setCode("0000");
        commonResponse.setMessage("사용가능한 닉네임 입니다.");
        return commonResponse;
    }
}
