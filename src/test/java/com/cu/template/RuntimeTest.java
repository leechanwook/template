package com.cu.template;

import com.cu.template.entity.Group;
import com.cu.template.entity.Member;
import com.cu.template.entity.MemberGroup;
import com.cu.template.model.type.GroupRole;
import com.cu.template.repository.jpa.GroupRepository;
import com.cu.template.repository.jpa.MemberGroupRepository;
import com.cu.template.repository.jpa.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RuntimeTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    GroupRepository groupRepository;

    @Autowired
    MemberGroupRepository memberGroupRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    @Transactional
    @Rollback(false)
    public void 테스트조회(){
        List<Member> members = memberRepository.findAll();

//        Member member = new Member();

//        memberRepository.findOne()

        for (Member member:members) {
            log.debug("item["+member.getUserId()+"]");
            MemberGroup memberGroup = member.getMemberGroup().get(0);
            Group group = memberGroup.getGroup();
            log.debug("groupName"+group.getGroupName()+"]");
        }

        log.debug("member["+members+"]");
//        member.
    }

//    @Test
//    @Transactional
    public void 테스트(){
        System.out.println("테스트");
        Group group = new Group();
        group.setGroupName("project_guest");
        group.setGroupRole(GroupRole.Maintainer);
        groupRepository.save(group);
//        entityManager.persist(group);



        Member member = new Member();
        member.setUserId("test1");
        member.setPassword("1234");
        memberRepository.save(member);
//        entityManager.persist(member);


        MemberGroup memberGroup = new MemberGroup();
        memberGroup.setGroup(group);
        memberGroup.setMember(member);
        memberGroupRepository.save(memberGroup);

    }
}
