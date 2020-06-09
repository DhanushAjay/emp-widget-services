package com.osi.emp_widget.security;
/*
 * Created by     : Eppalapalli Ajay Kumar
 * Employee ID    : NS2060
 * Created  on    : 7/6/2020 6:39 PM
 * Project        : com.osi.emp_widget.security
 * Organization   : OSI Digital Pvt Ltd.
 */
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Security Configuration
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().passwordEncoder(org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance())
		.withUser("user").password("secretUser").roles("USER").and()
		.withUser("admin").password("secretAdmin").roles("USER","ADMIN");
	}

	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
          .antMatchers("/Widget/**").hasRole("USER")
          .antMatchers("/EmpWidget/**").hasRole("USER")
          .antMatchers("/EmpDashboard/**").hasRole("USER")
          .antMatchers("/WidgetSettings/**").hasRole("USER")
          .antMatchers("/**").hasRole("ADMIN")
          .and().csrf().disable()
          .headers().frameOptions().disable();
    }
}