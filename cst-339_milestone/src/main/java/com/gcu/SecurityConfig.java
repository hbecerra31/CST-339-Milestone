package com.gcu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.gcu.business.UserBusinessService;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
    private UserBusinessService service;
	
	/*@Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
        	.authorizeHttpRequests()
        			.requestMatchers("/", "/images/**", "/register/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .formLogin()
                        .loginPage("/login")
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .permitAll()
                        .defaultSuccessUrl("/claims", true)
                        .and()
                .logout()
                        .logoutUrl("/logout")
                        .invalidateHttpSession(true)
                        .clearAuthentication(true)
                        .permitAll()
                        .logoutSuccessUrl("/");
		
		
		return http.build();
	}
	
	
	@Bean
	InMemoryUserDetailsManager userDetailsService() {
		UserDetails user = User.withDefaultPasswordEncoder()
										.username("test")
										.password("test")
										.roles("USER")
										.build();
		return new InMemoryUserDetailsManager(user);
	}
	
	/*
	@Bean
	void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(service)
			.passwordEncoder(passwordEncoder());
	}
	*/
}
