package cl.jrios.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import cl.jrios.service.AuthServiceImpl;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	private UserDetailsService servicioDetallesDeUsuario;
	private AuthenticationSuccessHandler manejadorDeAutentificacion;

	@Autowired
	public WebSecurityConfig(AuthServiceImpl servicioDetallesDeUsuario,
			ManejadorDeAutentificacionPersonalizado manejadorDeAutentificacion) {

		this.servicioDetallesDeUsuario = servicioDetallesDeUsuario;
		this.manejadorDeAutentificacion = manejadorDeAutentificacion;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(servicioDetallesDeUsuario).passwordEncoder(EncoderUtils.passwordEncoder());

	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN").antMatchers("/login")
				.permitAll().antMatchers("/registro").permitAll()

				.requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll().anyRequest()
				.authenticated().and().formLogin().loginPage("/login").successHandler(manejadorDeAutentificacion)
				.failureUrl("/login?error=true").usernameParameter("correo").passwordParameter("contrasenia").and()
				.exceptionHandling().accessDeniedPage("/recurso-prohibido");
	}

}
