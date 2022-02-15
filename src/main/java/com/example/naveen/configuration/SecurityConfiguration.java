package com.example.naveen.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.naveen.aunthentication.AuthService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	AuthService authService;
	@Bean
	 public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
 	
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(authService).passwordEncoder(bCryptPasswordEncoder());
		
	}
    @Override
    protected void configure(HttpSecurity http) throws Exception {
 
        http.csrf().disable();
        http.authorizeRequests().antMatchers("/", "/home").permitAll();
		
        http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')");
		 
		
		 http.authorizeRequests().antMatchers("/student/**").access("hasAnyRole('ROLE_STUDENT', 'ROLE_ADMIN')");
		
		  http.authorizeRequests().antMatchers("/teacher/**").access("hasRole('ROLE_TEACHER')");

        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
        
        // Config for Login Form
        http.authorizeRequests().and().formLogin()//
                // Submit URL of login page.
                .loginProcessingUrl("/j_spring_security_check") // Submit URL
                .loginPage("/login")//
                .defaultSuccessUrl("/login1")//
                .failureUrl("/login?error=true")//
                .usernameParameter("userName")//
                .passwordParameter("password")
                // Config for Logout Page
                // (Go to home page).
                .and().logout().logoutUrl("/j_spring_security_logout").logoutSuccessUrl("/logout");
  

        // Submit URL of login page.
  

        //http.authorizeRequests().antMatchers("/class").access("hasAnyRole('ROLE_STUDENT')");
    } 
    @Bean
    public AuthenticationManager am() throws Exception {
    	return authenticationManager();
    }
	

}
