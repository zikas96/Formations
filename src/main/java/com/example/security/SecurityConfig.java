package com.example.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@SuppressWarnings({"deprecation"})
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private DataSource dataSource;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*verification d'authentification d'un utilisateur avec la base de donnes
		 * 
		 */
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.usersByUsernameQuery("select email as principal ,password as credentials, true from client where email=?")
		.authoritiesByUsernameQuery("select cl.email as principal, cl.role_client as role  from client cl"
				+ " where cl.email=?")
		.passwordEncoder(NoOpPasswordEncoder.getInstance());
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*puisque l'application est securisé on donne l'acces sans authentification a certaines 
		 * page pour qu'on puisse creer un compte, se loger.
		 * apres avoir authentifier vous etes dirige directement vers la page d'authantification
		 */
/*		http
		.authorizeRequests().antMatchers("/**").authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.permitAll()
		.defaultSuccessUrl("/Course/Index");*/
		http
		.csrf()
		.disable()
		.authorizeRequests().antMatchers("/Session/inscription","/Session/listcs").authenticated()
		.and()
		.formLogin()
		.loginPage("/login")
		.permitAll()
		.defaultSuccessUrl("/Session/listcs");
		
		
		
	}
	

}