package com.myuniversity.course.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	// Add a reference to our security data source
	@Autowired
	private DataSource securityDataSource;
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		// Temporary add user for in memory authentication
//		UserBuilder users = User.withDefaultPasswordEncoder();
//		
//		auth.inMemoryAuthentication()
//			.withUser(users.username("john").password("test123").roles("STUDENT"))
//			.withUser(users.username("nick").password("test123").roles("STUDENT"))
//			.withUser(users.username("tammy").password("test123").roles("INSTRUCTOR"))
//			.withUser(users.username("lucy").password("test123").roles("INSTRUCTOR"));
		
		// User JDBC authentication
		auth.jdbcAuthentication().dataSource(securityDataSource);
		
	}

	// Configure security of web paths in application,login,logout
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// Restrict access based on the HttpServletReqeust
		// Any request to the application must be logged in
		http.authorizeRequests()										
			.antMatchers("/").hasAnyRole("STUDENT","INSTRUCTOR","ADMIN")
			.antMatchers("/students/**").hasRole("STUDENT")
			.antMatchers("/instructors/**").hasRole("INSTRUCTOR")
			.antMatchers("/admins/**").hasRole("ADMIN")
			.and()
			.formLogin() 											// Customizing the form
				.loginPage("/showLoginPage")						// Show custom form at the request mapping
				.loginProcessingUrl("/authenticateTheUser")			// Login form should POST data to this URL, check user and password
				.permitAll()										// Allow all user to see login page
			.and()
			.logout().permitAll()									// Add logout support
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied");
	}		
	
	
}
