package by.htp.cinema.SpringConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@Import({ SpringDaoConfig.class, SpringServiceConfig.class })
@ImportResource({"/WEB-INF/MainServlet-servlet.xml"})
public class SpringMainConfig {
	{
		System.out.println("SpringMainConfig");
	}

}
 