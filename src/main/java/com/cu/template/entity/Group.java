package com.cu.template.entity;

import com.cu.template.model.type.GroupRole;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.List;

@Entity
@Slf4j
@Getter
@Setter
@Table(name="T_GROUP")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;

    @Column
    private String groupName;

    @Column
    private int groupType;              //1 member, 2 : group

    @Column
    private int visibilityLevel;        //1 private, 2 public

    @Column
    @Enumerated(EnumType.STRING)
    private GroupRole groupRole;        //Guest, Reporter, Developer, Maintainer

    @Column
    private int groupStatus;                 //Invite, Ok

    @OneToMany(mappedBy = "group")
    private List<MemberGroup> memberGroup;
}
