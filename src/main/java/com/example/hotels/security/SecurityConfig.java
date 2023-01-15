package com.example.hotels.security;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	 @Autowired
	 private DataSource dataSource;
	 
 @Override
 protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	 PasswordEncoder passwordEncoder = passwordEncoder ();
	 /*
	 System.out.println("Passwors Encoded BCRYPT :******************** ");
	 System.out.println(passwordEncoder.encode("123"));
	 auth.jdbcAuthentication().dataSource(dataSource)
	  .usersByUsernameQuery("select nom , mdp  from  client where nom =?")
	  .passwordEncoder(passwordEncoder)
	  .rolePrefix("CLIENT");
	 */
	 
	 auth.inMemoryAuthentication().withUser("admin").password(passwordEncoder.encode("123")).roles("ADMIN");
	 /* auth.inMemoryAuthentication().withUser("admin").password("{noop}123").roles("ADMIN");*/

     auth.inMemoryAuthentication().withUser("maram").password(passwordEncoder.encode("123")).roles("CLIENT");
     auth.inMemoryAuthentication().withUser("malak").password(passwordEncoder.encode("123")).roles("CLIENT");
     auth.inMemoryAuthentication().withUser("aseel").password(passwordEncoder.encode("123")).roles("CLIENT");
     
 }

 
 @Override
 protected void configure(HttpSecurity http) throws Exception {
	
	 http.authorizeRequests().antMatchers("/showCreate").hasAnyRole("ADMIN");
	 http.authorizeRequests().antMatchers("/saveHotel").hasAnyRole("ADMIN");
	 http.authorizeRequests().antMatchers("/ListeHotels").hasAnyRole("ADMIN","CLIENT","RESPONSABLE");
	 
	 http.authorizeRequests().antMatchers("/supprimerProduit","/modifierProduit","/updateProduit").hasAnyRole("ADMIN");
	 
	 http.authorizeRequests().anyRequest().authenticated();
	 http.formLogin();
	 http.exceptionHandling().accessDeniedPage("/accessDenied");

 } 
 @Bean
 public PasswordEncoder passwordEncoder () {
 return new BCryptPasswordEncoder();
 }



}
