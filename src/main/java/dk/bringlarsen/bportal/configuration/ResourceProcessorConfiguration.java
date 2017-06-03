package dk.bringlarsen.bportal.configuration;

import dk.bringlarsen.bportal.api.controller.ImportController;
import dk.bringlarsen.bportal.model.Player;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

@Configuration
public class ResourceProcessorConfiguration {

    @Bean
    public ResourceProcessor<Resource<Player>> playerProcessor() {
        return new ResourceProcessor<Resource<Player>>() {

            @Override
            public Resource<Player> process(Resource<Player> resource) {
                resource.add(linkTo(ImportController.class).withRel("import"));
                return resource;
            }
        };
    }
}
