package com.pabbasadwika.module5.springSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class webSecurityConfig {


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
        httpSecurity
                //at new login page is our ui code so, it will take ui login page we need add it in templates
//                .formLogin(formLoginConfig -> formLoginConfig.loginPage("/newloginPage.html")
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/post/allPost").permitAll()
                        .requestMatchers("/post/**").hasAnyRole("ADMIN")
                                .anyRequest().authenticated())
                .csrf(csrfConfig -> csrfConfig.disable())
                .sessionManagement(sessionConfig -> sessionConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .formLogin(Customizer.withDefaults());

        return httpSecurity.build();
    }


    @Bean
    UserDetailsService myInMemoryUserDetailService(){
        UserDetails normalUSer = User
                .withUsername("Sadwika")
                .password(myPasswordEncoder().encode("Sadwi@123"))
                .roles("USER")
                .build();

        UserDetails adminUser = User
                .withUsername("Admin")
                .password(myPasswordEncoder().encode("admin@123"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(normalUSer,adminUser);
    }

    @Bean
    PasswordEncoder myPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

//requestmatchers make the api public so, no need to access if I want post/** -> all contains post will be made public
/*
                .sessionManagement(sessionConfig -> sessionConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
as form login is dependent on jsessionId , if keep it as stateless, the page will looped every time .

as there is no session it wont go any where , as session is not created
 */


