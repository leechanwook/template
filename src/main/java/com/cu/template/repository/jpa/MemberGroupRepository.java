package com.cu.template.repository.jpa;

import com.cu.template.entity.Group;
import com.cu.template.entity.MemberGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberGroupRepository extends JpaRepository<MemberGroup, Long> {

//    Optional<Member> findByUserId(String userId);
}
