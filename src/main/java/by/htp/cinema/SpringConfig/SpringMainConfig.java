package by.htp.cinema.SpringConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@Import({ SpringDaoConfig.class, SpringServiceConfig.class, SpringSecurityConfig.class })
public class SpringMainConfig {
	{
		System.out.println("SpringMainConfig");
	}

}
