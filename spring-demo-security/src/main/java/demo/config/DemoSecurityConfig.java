package demo.config;

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
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource securityDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		UserBuilder user = User.withDefaultPasswordEncoder();
//		auth.inMemoryAuthentication()
//			.withUser(user.username("dan1").password("123").roles("EMPLOYEE"))
//			.withUser(user.username("dan2").password("123").roles("EMPLOYEE", "MANAGER"))
//			.withUser(user.username("dan3").password("123").roles("EMPLOYEE", "ADMIN"));
		auth.jdbcAuthentication().dataSource(securityDataSource);
			// .usersByUsernameQuery("select username, password, enabled from users where username = ?")
			// .authoritiesByUsernameQuery("select username, authority from authorities where username = ?");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/resources/css/**").permitAll()
			.antMatchers("/resources/js/**").permitAll()
			.antMatchers("/").permitAll()
			.antMatchers("/login").hasRole("EMPLOYEE")
			.antMatchers("/leaders/**").hasRole("MANAGER")
			.antMatchers("/systems/**").hasRole("ADMIN")
			.anyRequest().authenticated()
			.and().formLogin()
				.loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll()
			.and().logout()
				.permitAll()
			.and()
				.exceptionHandling().accessDeniedPage("/access-denied");
	}
}
