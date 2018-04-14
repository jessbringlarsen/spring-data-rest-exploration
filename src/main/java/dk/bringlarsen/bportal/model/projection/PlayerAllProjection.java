package dk.bringlarsen.bportal.model.projection;

import dk.bringlarsen.bportal.model.ClubMembership;
import dk.bringlarsen.bportal.model.Player;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "playerAllProjection", types = { Player.class })
public interface PlayerAllProjection {
    String getName();

    @Value("#{target.birthdate.format(java.time.format.DateTimeFormatter.ISO_DATE)}")
    String getBirthdate();

    @Value("#{target.name}")
    String getMyName();

    List<ClubMembership> getClubMemberships();
}