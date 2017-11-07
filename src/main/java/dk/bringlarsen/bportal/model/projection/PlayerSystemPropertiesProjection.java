package dk.bringlarsen.bportal.model.projection;

import dk.bringlarsen.bportal.model.Player;
import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(name = "playerSystemPropertiesProjection", types = { Player.class })
public interface PlayerSystemPropertiesProjection {
    Long getId();
    Date getVersion();
}