 package com.bach.Commerce.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.bach.Commerce.security.oauth.CustomOAuth2UserService;
import com.bach.Commerce.security.oauth.OAuth2LoginSuccessHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
			.and()
			.addFilterBefore(getCustomLoginFilter(), CustomLoginFilter.class)
			.formLogin().permitAll()
				.loginPage("/dang-nhap").usernameParameter("username").loginProcessingUrl("/login").defaultSuccessUrl("/trang-chu")
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

	//Trả về bean authenticationManager theo mặc định
	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Autowired
	private BeforeAuthenticationFilter beforeAuthenticationFilter;

	private CustomLoginFilter getCustomLoginFilter() throws Exception {
		CustomLoginFilter filter = new CustomLoginFilter("/login", "POST");
		filter.setAuthenticationManager(authenticationManager());
		filter.setAuthenticationFailureHandler(new AuthenticationFailureHandler() {
			@Override
			public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
				if(!response.isCommitted()){
					response.sendRedirect("dang-nhap?error");
				}
			}
		});

		return filter;
	}
}
//