package com.buddy.study.account.service;

import com.buddy.study.account.domain.Account;
import com.buddy.study.account.dto.JoinRequest;
import com.buddy.study.account.dto.LoginRequest;
import com.buddy.study.account.dto.LoginResponse;
import com.buddy.study.account.exception.EmailDuplication;
import com.buddy.study.account.exception.LoginException;
import com.buddy.study.account.repository.AccountRepository;
import com.buddy.study.common.dto.CommonResponse;
import com.buddy.study.common.service.CommonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    final private AccountRepository accountRepository;
    final private CommonService commonService;
    public CommonResponse saveUser(JoinRequest joinRequest){
        Account account= new Account();
        account.setEmail(joinRequest.getEmail());
        account.setName(joinRequest.getName());
        account.setPassword(joinRequest.getPassword());
        accountRepository.save(account);
        return commonService.response("0000","회원가입에 성공했습니다", null);
    }
    public CommonResponse outUser(Long id){
        Account account= accountRepository.findById(id).orElse(null);
        account.setIsDelete(true);
        accountRepository.save(account);
        return commonService.response("0000","회원탈퇴에 성공했습니다.", null);
    }
    public CommonResponse checkUser(String email){
        if(accountRepository.findByEmail(email)!=null){
            throw new EmailDuplication("이메일이 중복되었습니다.");
        }
        return commonService.response("0000","사용가능한 이메일입니다.", null);
    }
    public CommonResponse loginUser(LoginRequest loginRequest){
        Account account=accountRepository.findByEmail(loginRequest.getEmail());
        if(account==null){
            throw new LoginException("없는 아이디입니다.");
        }
        if(!account.getPassword().equals(loginRequest.getPassword())){
            throw new LoginException("패스워드가 일치하지 않습니다.");
        }
        if(account.getIsDelete()){
            throw new LoginException("회원 탈퇴한 이메일입니다.");
        }
        LoginResponse loginResponse=new LoginResponse();
        loginResponse.setUid(account.getId());
        return commonService.response("0000","로그인에 성공했습니다.", loginResponse);
    }

}
