package com.buddy.study.group.service;

import com.buddy.study.common.dto.CommonResponse;
import com.buddy.study.common.service.CommonService;
import com.buddy.study.group.repository.GroupRepository;
import com.buddy.study.group.repository.MappingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupService {
    final private GroupRepository groupRepository;
    final private MappingRepository mappingRepository;
    final private CommonService commonService;
    private CommonResponse commonResponse=new CommonResponse();
    public CommonResponse createRoom(){
        return commonResponse.success("방 생성이 완료되었습니다.",null);
    }

}
