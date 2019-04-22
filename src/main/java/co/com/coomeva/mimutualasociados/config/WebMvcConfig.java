/**
 * File WebMvcConfig.java
 * 
 * @Project MiMutualAsociados. Coomeva MiMutual
 * @Date 17/04/2019 
 * @Package co.com.coomeva.mimutualasociados.config
 */

package co.com.coomeva.mimutualasociados.config;

import java.util.Arrays;
import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

/**
 * Class WebMvcConfig
 *
 * @Version 1 
 * @Date 17/04/2019 
 * @Author Jose Lover Daza Rojas
 */

@Configuration
public class WebMvcConfig {

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuracion = new CorsConfiguration();
		configuracion.setAllowedOrigins(Arrays.asList("*"));
		configuracion.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
		configuracion.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type", "Access-Control-Allow-Origin"));
		configuracion.setExposedHeaders(Arrays.asList("Access-Control-Allow-Origin"));
		configuracion.setAllowCredentials(true);
		UrlBasedCorsConfigurationSource fuente = new UrlBasedCorsConfigurationSource();
		fuente.registerCorsConfiguration("/**", configuracion);
		return fuente;
	}
	
	@Bean
	public LocaleResolver localResolver() {
	    SessionLocaleResolver localResolver = new SessionLocaleResolver();
	    localResolver.setDefaultLocale(new Locale("es", "CO"));
	    return localResolver;
	}
	
}