package com.backend.yago.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.backend.yago.servicioImpl.ServicioUsuarioImpl;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	ServicioUsuarioImpl su;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public String encripta(String password) {
		return passwordEncoder().encode(password);
	}
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	 /*auth.inMemoryAuthentication().withUser("user").password(encripta("temporal")).roles("USER");
  	auth.inMemoryAuthentication().withUser("admin").password(encripta("temporal")).roles("ADMIN");*/
	auth.userDetailsService(su);
  }	
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
      http.authorizeRequests().antMatchers(HttpMethod.GET,"/index", "/contacto", "/productos", "/acercade", "/comprado").hasAnyRole("ADMIN", "USER");
      http.authorizeRequests().antMatchers(HttpMethod.GET,"/admin", "/insertar", "/modificar", "/eliminar", "/acercadeadmin", "/contactoadmin").hasRole("ADMIN");
      http.authorizeRequests().antMatchers(HttpMethod.POST, "/submit").hasRole("ADMIN");
      http.httpBasic();
      http.formLogin().loginPage("/login");
      http.logout().logoutSuccessUrl("/home");
      http.exceptionHandling().accessDeniedPage("/403");
	  http.csrf().disable();
   }

}
