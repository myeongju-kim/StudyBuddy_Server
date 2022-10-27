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
    public CommonResponse response(String code, String message, Object object){
        CommonResponse commonResponse=new CommonResponse();
        commonResponse.setCode("0000");
        commonResponse.setMessage(message);
        commonResponse.setResult(object);
        return commonResponse;
    }
    public CommonResponse checkUser(String name){
        if(accountRepository.findByName(name)!=null){
            throw new NameDuplication("닉네임이 중복되었습니다.");
        }
        return response("0000","사용 가능한 닉네임입니다.",null);
    }

}
