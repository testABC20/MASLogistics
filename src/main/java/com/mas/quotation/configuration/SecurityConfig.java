package com.mas.quotation.configuration;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(requests -> requests.antMatchers("/api/**").permitAll().anyRequest().
                fullyAuthenticated()).httpBasic(withDefaults()).csrf(csrf -> csrf.disable()).
                headers(withDefaults()).cors(cors -> cors.configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues()));
        
	}
	
}