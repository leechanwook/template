package com.cu.template.service;

import com.cu.template.entity.Member;
import com.cu.template.model.SecurityUserDetails;
import com.cu.template.repository.jpa.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Member> memberItem = memberRepository.findByUserId(username);
        memberItem.orElseThrow(() -> new UsernameNotFoundException("username not found"));

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//        authorities.
        Member member = memberItem.get();
        SecurityUserDetails securityUserDetails = new SecurityUserDetails();
        securityUserDetails.setUsername(member.getUserId());
        securityUserDetails.setPassword(member.getPassword());
        securityUserDetails.setEnabled(true);
        securityUserDetails.setAuthorities(authorities);
        return securityUserDetails;
    }
}
