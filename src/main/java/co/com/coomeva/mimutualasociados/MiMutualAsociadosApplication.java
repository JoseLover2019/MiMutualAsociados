/**
 * File Application.java
 * 
 * @Project MiMutualAsociados. Coomeva MiMutual
 * @Date 17/04/2019 
 * @Package co.com.coomeva.mimutualasociados
 */

package co.com.coomeva.mimutualasociados;

import java.util.TimeZone;
import javax.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Class Application
 *
 * @Version 1 
 * @Date 17/04/2019 
 * @Author Jose Lover Daza Rojas
 */

@SpringBootApplication
@EnableScheduling
public class MiMutualAsociadosApplication extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MiMutualAsociadosApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(MiMutualAsociadosApplication.class, args);
	}
	
	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("EST"));
	}
	
}