package com.cu.template.controller;

import com.cu.template.model.dto.LoginProcessDto;
import com.cu.template.service.UserDetailsServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    UserDetailsServiceImpl userDetailService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public Map login(){
        Map item = new HashMap();
        item.put("test", "1234");
        return item;
    }

    @PostMapping("/signin")
    public Map loginProcess(@RequestBody LoginProcessDto loginProcessDto){
        log.debug("loginProcess["+loginProcessDto.toString()+"[");
        UserDetails userDetails = userDetailService.loadUserByUsername(loginProcessDto.getUsername());

        String dbPassword = userDetails.getPassword();
        String password = loginProcessDto.getPassword();

        Map item = new HashMap();
        log.debug("dbPassword["+dbPassword+"]password["+password+"]");
        if(password.equals(dbPassword)){      //성공
            item.put("resultCode", "200");
            item.put("resultMsg", "OK");
        }else{
            throw new UsernameNotFoundException("user name not found");
        }
        return item;
    }


}
