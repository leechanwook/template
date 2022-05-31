package com.cu.template.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Slf4j
@Getter
@Setter
@Table(name="T_MEMBER")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberSeq;

    @Column(unique=true)
    private String userId;

    @Column
    private String password;

    @Column
    private boolean enabled;

    @OneToMany(mappedBy = "member")
    private List<MemberGroup> memberGroup = new ArrayList<>();


}
