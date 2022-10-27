package com.buddy.study.group.service;

import com.buddy.study.account.domain.Account;
import com.buddy.study.account.dto.JoinRequest;
import com.buddy.study.account.dto.LoginRequest;
import com.buddy.study.account.dto.LoginResponse;
import com.buddy.study.account.exception.EmailDuplication;
import com.buddy.study.account.exception.LoginException;
import com.buddy.study.account.repository.AccountRepository;
import com.buddy.study.common.dto.CommonResponse;
import com.buddy.study.group.domain.Mapping;
import com.buddy.study.group.repository.GroupRepository;
import com.buddy.study.group.repository.MappingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupService {
    final private GroupRepository groupRepository;
    final private MappingRepository mappingRepository;
    private CommonResponse commonResponse=new CommonResponse();

}
