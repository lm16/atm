package com.lm16.config;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

public class TestSecurity2 {

    public static void main(String[] args) {
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        UserDetails user = User.withUsername("user").password(passwordEncoder.encode("password")).roles("USER").build();
        userDetailsManager.createUser(user);

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsManager);
        provider.setPasswordEncoder(passwordEncoder);

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken("user", "password");

        Class<? extends Authentication> toTest = authenticationToken.getClass();
        System.out.println(provider.supports(toTest));

        Authentication result = provider.authenticate(authenticationToken);

        System.out.println(result);
    }

}
