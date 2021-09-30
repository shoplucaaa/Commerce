 package com.bach.Commerce.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.bach.Commerce.security.oauth.CustomOAuth2UserService;
import com.bach.Commerce.security.oauth.OAuth2LoginSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	CustomOAuth2UserService oAuth2UserService;
	
	@Autowired
	OAuth2LoginSuccessHandler oAuth2LoginSuccessHandler;
	
	@Bean
	public BCryptPasswordEncoder PasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
		//auth.authenticationProvider(authenticationProvider());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//phân quyền
		http.csrf().disable()
			.authorizeRequests()
			.antMatchers("/oauth2/**").permitAll()
			.antMatchers("/admin/**").hasAnyRole("ADMIN")
			.antMatchers("/member/**").hasAnyRole("USER","ADMIN").anyRequest().permitAll()
			//cấu hình giao diện xác thực
			.and().formLogin().permitAll()
			.loginPage("/dang-nhap").loginProcessingUrl("/login")
			.and()
			.logout().permitAll()
			.and()
			.oauth2Login().loginPage("/login")
			.userInfoEndpoint().userService(oAuth2UserService)
			.and()
			.successHandler(oAuth2LoginSuccessHandler);
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/js/**", "/img/**");
	}
	
}
