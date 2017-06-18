package com.backbase.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Spring Security configuration
 * @author wpjunior
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
		auth.inMemoryAuthentication().withUser("wilson").password("wilson").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests()
        	// set permission to avoid css, js, img to get access denied
            .antMatchers("/resources/**").permitAll() 
            .anyRequest().authenticated()
            .and()
        .formLogin()
            .loginPage("/login")
            .permitAll()
            .and()
        .logout()                                    
            .permitAll();

        http.authorizeRequests()
        	.antMatchers("/", "/")
        	.access("hasRole('ADMIN')")
        	.antMatchers("/**")
			.access("hasRole('ADMIN')").and()
			.formLogin().and()
			.exceptionHandling()
			.accessDeniedPage("/denied");

	}

}
