package cl.jrios.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
    	String adminUsername = "admin@mail.cl";
    	String adminPassword = passwordEncoder().encode("1234");
    	String adminRole = "ADMIN";
    	

    	String userUsername = "user@mail.cl";
    	String userPassword = passwordEncoder().encode("1234");
    	String userRole = "USER";
    	
    	auth.inMemoryAuthentication()
    	.withUser(adminUsername).password(adminPassword).roles(adminRole)
    	.and()
    	.withUser(userUsername).password(userPassword).roles(userRole);
    	
       }
    
    @Override
    public void configure(HttpSecurity http)throws Exception {
        http.csrf().disable()
        .authorizeRequests()
        .antMatchers("/admin/**").hasRole("ADMIN")
        .antMatchers("/login").permitAll()
        .antMatchers("/registro").permitAll()
        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
        .anyRequest().authenticated()
        .and().formLogin().loginPage("/login").permitAll()
        .failureUrl("/login?error=true")
        //***********************************************************
        .usernameParameter("correo").passwordParameter("contrasenia")
        .defaultSuccessUrl("/")
        .and().exceptionHandling().accessDeniedPage("/recurso-prohibido");
    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
    	return new BCryptPasswordEncoder();
    	
    }
    
}
