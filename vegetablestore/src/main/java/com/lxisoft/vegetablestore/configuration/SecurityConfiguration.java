package com.lxisoft.vegetablestore.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    auth.inMemoryAuthentication().withUser("Admin").password("Admin").roles("ADMIN").and()
            .withUser("User").password("User").roles("USER");/*.and().formLogin().loginPage("/login")
            .defaultSuccessUrl("/").and().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
*/}


@Bean
public PasswordEncoder getPasswordEncoder() {
    return NoOpPasswordEncoder.getInstance();
}
}
