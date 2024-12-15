package com.basicSecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class EMSUpgradedSecurityconfig {

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user = User.withUsername("nikhil").password(passwordEncoder().encode("Pwd1")).roles("USER").build();
		UserDetails admin = User.withUsername("Amit").password(passwordEncoder().encode("Pwd2")).roles("USER").build();
		UserDetails useradmin = User.withUsername("Paramesh").password(passwordEncoder().encode("Pwd3")).roles("USER")
				.build();
		return new InMemoryUserDetailsManager(user, admin, useradmin);
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.authorizeRequests()
		.requestMatchers("/nonsecureapp").permitAll()
		.requestMatchers("/text","/welcome").authenticated()
		.and()
		.httpBasic().and().build();
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
