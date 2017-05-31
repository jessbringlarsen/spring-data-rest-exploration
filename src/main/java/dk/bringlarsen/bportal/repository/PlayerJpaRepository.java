package dk.bringlarsen.bportal.repository;

import dk.bringlarsen.bportal.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface PlayerJpaRepository extends JpaRepository<Player, Long> {

    @Query("select p from Player p where p.name like %?1")
    List<Player> findByName(String name);

    List<Player> findByNameLikeAndVersionOrderByName(String name, int version);

    @Query("SELECT p FROM Player p " +
            "JOIN p.clubMemberships c " +
            "ORDER BY p.id, c.club.id")
    List<Player> findAllOrderbyPlayerAndClub();
}
