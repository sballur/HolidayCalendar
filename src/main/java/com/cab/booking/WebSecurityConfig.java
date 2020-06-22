package com.cab.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.client.RestTemplate;

import com.cab.booking.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
   
	@Autowired
    private UserService userDetailsService;
    
    @Autowired
    private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    public RestTemplate restTemplate() {
       return new RestTemplate();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    		http
                	.authorizeRequests()
                    .antMatchers("/resources/**", "/registration")
                    .permitAll()
                    .anyRequest()
                    .authenticated()
                .and()
                	.formLogin()
                	.successHandler(customAuthenticationSuccessHandler)
                    .loginPage("/login")
                    .permitAll()
                .and()
            		.logout()
                    .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
}