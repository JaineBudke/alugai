package br.ufrn.alugai;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.ufrn.alugai.service.UsuarioDetails;
import br.ufrn.alugai.service.UsuarioDetailsService;


@Configuration
@EnableWebSecurity
@ComponentScan("br.com.adapt.service")
public class SecurityConfig extends WebSecurityConfigurerAdapter  {
	@Autowired
	private UsuarioDetailsService userDetailsService;
	 
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
	  throws Exception {
	    auth.authenticationProvider(authenticationProvider());
	}

	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		http
        .authorizeRequests()
	        .antMatchers("/view/plugins**").permitAll() 
	        .antMatchers("/view/**").permitAll() 
	        .antMatchers("/css/**").permitAll() 
	        .antMatchers("/register**").permitAll()
	        .antMatchers("/index").permitAll()
	        .antMatchers("/client-register-action").permitAll()
	        .anyRequest().authenticated()
	        .and()
        .formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/dashboard")
            .permitAll()
            .and()
        .logout()                                    
            .permitAll();
    }
	 
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
	    DaoAuthenticationProvider authProvider
	      = new DaoAuthenticationProvider();
	    authProvider.setUserDetailsService(userDetailsService);
	    authProvider.setPasswordEncoder(encoder());
	    return authProvider;
	}
	 
	@Bean
	public PasswordEncoder encoder() {
	    return new BCryptPasswordEncoder(11);
	}

}