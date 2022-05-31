package com.cu.template.config;

import com.cu.template.security.FailureHandler;
import com.cu.template.security.SecurityExceptionHandler;
import com.cu.template.security.SuccessHandler;
import com.cu.template.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    SuccessHandler successHandler;
    @Autowired
    FailureHandler failureHandler;

//    @Autowired
//    SecurityExceptionHandler securityExceptionHandler;


    public static void main(String[] args) {
        BCryptPasswordEncoder aa = new BCryptPasswordEncoder();
        System.out.println(aa.encode("1234"));
    }

    @Autowired
    private UserDetailsServiceImpl userDetailService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
    }



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .httpBasic().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()
                .antMatchers("/signin","/signup","/excel").permitAll()
                .anyRequest().hasRole("USER")
            .and()
                .exceptionHandling().authenticationEntryPoint(new SecurityExceptionHandler());
//                .exceptionHandling(securityExceptionHandler);
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService);//.passwordEncoder(passwordEncoder());
//        {bcrypt}$2a$10$kkZUh/fEIysZHLEsDWcEneL0tON5zu72zY8tf8fmO0xIU9tdDWEqC
//        auth.userDetailsService(memberService).passwordEncoder(passwordEncoder());
    }

}