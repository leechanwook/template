package com.cu.template.repository.jpa;

import com.cu.template.entity.Group;
import com.cu.template.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

//    Optional<Member> findByUserId(String userId);


}
