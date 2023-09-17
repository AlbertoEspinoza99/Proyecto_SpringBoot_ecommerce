package com.mastershop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.mastershop.security.UserSecurity;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

	
	@Value("${spring.security.debug:false}")
    boolean securityDebug;

	@Bean
	public BCryptPasswordEncoder encriptar() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

	    http.csrf().disable()
	        .authorizeRequests()
	        .requestMatchers("/IniciarSesion/login","/IniciarSesion/registrar").permitAll() // Permitir acceso a la página de login sin autenticación
	        .requestMatchers("/usuario/**").hasRole("ADMIN") // Acceso a enlaces bajo "/usuario/**" solo para el rol "ADMIN"
	        .requestMatchers("/pagoo/intranet", "/pagoo/**", "/ruta/**").authenticated() // Acceso a enlaces bajo "/medicamento/**", "/medico/**" y "/boleta/**" requiere autenticación
	        .and()
	        .formLogin()
	        .loginPage("/IniciarSesion/login")
	        .defaultSuccessUrl("/ruta/direccion")
	        .and()
	        .logout()
	        .logoutUrl("/logout") // Especifica la URL de cierre de sesión
	        .logoutSuccessUrl("/servicio/MenuVenta/lista")
	        .and().exceptionHandling().accessDeniedPage("/IniciarSesion/denegado");

	    return http.build();
	}
	
	
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserSecurity();
	}

	@Bean
	public AuthenticationProvider authenticationProvider(){
		DaoAuthenticationProvider salida=new DaoAuthenticationProvider();
		//dos atributos al objeto salida
		salida.setUserDetailsService(userDetailsService());
		salida.setPasswordEncoder(encriptar());
		return salida;
	}
	
	
	@Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.debug(securityDebug)
                .ignoring()
                .requestMatchers("/resources/**", "/static/**", "/img/**", "/lib/**", "/favicon.ico");
    }
	
	
	
	
	
	
}
