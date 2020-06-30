package com.lxisoft.MockExam.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.lxisoft.MockExam.service.UserService;
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserService userService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	

	 @Autowired
    CustomLoginSuccessHandler customLoginSuccessHandler;
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(userService);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		 http.authorizeRequests()
                .antMatchers("/admin").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/user").access("hasRole('ROLE_USER')")
                .antMatchers("/resources/**", "/registration")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin().loginPage("/login")
                .permitAll()
                .successHandler(customLoginSuccessHandler)
                .and()
                .logout()
                .logoutSuccessUrl("/logout")
                .permitAll();
	}
}
