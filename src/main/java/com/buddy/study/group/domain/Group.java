package com.buddy.study.group.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
public class Group {
    @Id
    @GeneratedValue
    @Column(name="groupId")
    private Long id;
    private String name;
    private Integer time;
    private Integer maxPerson;
    private Boolean isDelete=false;
}
