package com.buddy.study.group.domain;

import com.buddy.study.account.domain.Account;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Mapping {
    @Id
    @GeneratedValue
    @Column(name="mapId")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "userId")
    private Account account;
    @ManyToOne
    @JoinColumn(name = "groupId")
    private Group group;
}
