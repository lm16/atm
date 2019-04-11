package com.lm16.config;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;

public class TestSecurity {

    public static void main(String[] args) {
        /*
        注册
         */
        UserDetailsService userDetailsService = new InMemoryUserDetailsManager();
        ((InMemoryUserDetailsManager) userDetailsService).createUser(User.withUsername("lm16").password("gg").roles("USER").build());

//        UserDetails userDetails = userDetailsService.loadUserByUsername("lm16");
//        System.out.println(userDetails);

        /*
        背负者
         */
        AuthenticationProvider provider = new DaoAuthenticationProvider();
        ((DaoAuthenticationProvider) provider).setUserDetailsService(userDetailsService);

        List<AuthenticationProvider> providers = new ArrayList<>();
        providers.add(provider);

        /*
        管理器
         */
        AuthenticationManager manager = new ProviderManager(providers);

        /*
        验证
         */
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken("lm16", "gg");
        Authentication result = null;

        result = manager.authenticate(token);
        System.out.println(token+"\nhhhhhh");

        System.out.println(result);
    }
}
