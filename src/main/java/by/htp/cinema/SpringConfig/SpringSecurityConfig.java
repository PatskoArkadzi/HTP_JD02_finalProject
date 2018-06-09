package by.htp.cinema.SpringConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import by.htp.cinema.dao.UserDao;
import by.htp.cinema.service.impl.CustomUserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@Import({SpringDaoConfig.class})
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/newapp/user/chooseSeat/**").hasAnyRole("ROLE_ADMIN, ROLE_USER")
				.antMatchers("/newapp/admin/**").hasRole("ROLE_ADMIN").antMatchers("/messageDelete*").hasRole("ADMIM")
				.and().formLogin().loginProcessingUrl("/j_spring_security_check").loginPage("/newapp/user/login")
				.defaultSuccessUrl("/newapp/user/").usernameParameter("username").passwordParameter("password")
				.failureUrl("/newapp/user/error?error=true").and().csrf().disable().logout()
				.logoutUrl("/j_spring_security_logout").logoutSuccessUrl("/newapp/user/");
	}

	@Bean
	protected UserDetailsService userDetailsService(UserDao userDao) {
		CustomUserDetailsServiceImpl customUserDetailsServiceImpl = new CustomUserDetailsServiceImpl();
		customUserDetailsServiceImpl.setUserDao(userDao);
		return customUserDetailsServiceImpl;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService());
	}
}
