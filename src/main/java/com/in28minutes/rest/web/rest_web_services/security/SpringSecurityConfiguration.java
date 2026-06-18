package com.in28minutes.rest.web.rest_web_services.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
    @Bean
    public SecurityFilterChain filterchain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(auth-> auth.anyRequest().authenticated()); // all Request Should Be Authenticated
        http.httpBasic(Customizer.withDefaults()).csrf(csrf->csrf.disable()); // If Request Not Authenticated A web Page Will Be Shown And Disable csrf
        return http.build();

    }
    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails user = User.withUsername("hussain").password("{noop}885522").roles("User").build();
        return new InMemoryUserDetailsManager(user);
    }

}
