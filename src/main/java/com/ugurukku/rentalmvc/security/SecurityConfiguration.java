package com.ugurukku.rentalmvc.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
//@EnableWebSecurity
public class SecurityConfiguration {

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//       return http
//               .authorizeHttpRequests()
//               .requestMatchers(HttpMethod.GET,"/**")
//               .permitAll()
//               .requestMatchers(HttpMethod.POST,"/**")
//               .permitAll()
//               .and()
//               .formLogin()
//               .and()
//               .logout()
//               .and()
//               .build();
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
