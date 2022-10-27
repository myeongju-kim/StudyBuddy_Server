package com.buddy.study.group.service;

import com.buddy.study.account.domain.Account;
import com.buddy.study.account.dto.JoinRequest;
import com.buddy.study.account.dto.LoginRequest;
import com.buddy.study.account.dto.LoginResponse;
import com.buddy.study.account.exception.EmailDuplication;
import com.buddy.study.account.exception.LoginException;
import com.buddy.study.account.repository.AccountRepository;
import com.buddy.study.common.dto.CommonResponse;
import com.buddy.study.common.service.CommonService;
import com.buddy.study.group.domain.Mapping;
import com.buddy.study.group.repository.GroupRepository;
import com.buddy.study.group.repository.MappingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class GroupService {
    final private GroupRepository groupRepository;
    final private MappingRepository mappingRepository;
    final private CommonService commonService;
    private CommonResponse commonResponse=new CommonResponse();
    public CommonResponse createRoom(){
        return commonService.response("0000","방 생성이 완료되었습니다.",null);
    }

}
