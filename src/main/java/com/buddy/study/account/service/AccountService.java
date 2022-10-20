package com.buddy.study.account.service;

import com.buddy.study.account.domain.Account;
import com.buddy.study.account.dto.JoinRequest;
import com.buddy.study.account.exception.EmailDuplication;
import com.buddy.study.account.repository.AccountRepository;
import com.buddy.study.common.dto.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    final private AccountRepository accountRepository;
    public CommonResponse saveUser(JoinRequest joinRequest){
        Account account= new Account();
        account.setEmail(joinRequest.getEmail());
        account.setPassword(joinRequest.getPassword());
        accountRepository.save(account);

        CommonResponse commonResponse=new CommonResponse();
        commonResponse.setCode("0000");
        commonResponse.setMessage("회원가입에 성공했습니다.");
        return commonResponse;
    }
    public CommonResponse checkUser(String email){
        if(accountRepository.findByEmail(email)){
            throw new EmailDuplication("이메일이 중복되었습니다.");
        }
        CommonResponse commonResponse=new CommonResponse();
        commonResponse.setCode("0000");
        commonResponse.setMessage("회원가입 가능한 메일입니다.");
        return commonResponse;
    }

}
