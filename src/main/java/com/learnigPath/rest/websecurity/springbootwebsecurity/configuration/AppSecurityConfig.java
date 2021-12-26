package com.learnigPath.rest.websecurity.springbootwebsecurity.configuration;

import com.learnigPath.rest.websecurity.springbootwebsecurity.fliter.CustomAppFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private CustomAuthenticationProvider authenticationProvider;

    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
        UserDetails userdetails = User.withUsername("Ambar").password(passwordEncoder.encode("gupta")).authorities("read").build();
        userDetailsService.createUser(userdetails);

        auth.userDetailsService(userDetailsService);
    }*/

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.authenticationProvider(authenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.addFilterBefore(new CustomAppFilter(), BasicAuthenticationFilter.class);
        /*http.formLogin();*/
        http.authorizeRequests().antMatchers("/hello").authenticated();

    }

    /*@Bean
    public BCryptPasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }*/
}
