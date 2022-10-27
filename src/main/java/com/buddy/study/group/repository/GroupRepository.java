package com.buddy.study.group.repository;

import com.buddy.study.account.domain.Account;
import com.buddy.study.group.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group,Long> {

}
