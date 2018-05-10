package dk.bringlarsen.bportal.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages={"dk.bringlarsen.bportal.repository"})
public class JpaConfiguration {

}
