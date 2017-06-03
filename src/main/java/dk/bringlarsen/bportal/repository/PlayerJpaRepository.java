package dk.bringlarsen.bportal.repository;

import dk.bringlarsen.bportal.model.Player;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Examples of custom search methods all exposed on the search resource:
 * http://localhost:8080/api/players/search
 */
@RepositoryRestResource
public interface PlayerJpaRepository extends JpaRepository<Player, Long> {

    Player getByName(@Param("name") String name);

    @Query("select p from Player p where p.name like %?1")
    List<Player> findByName(@Param("name") String name);

    @Query("select p from Player p where p.name like %?1")
    List<Player> findByAndSort(@Param("name")String name, Sort sort);

    List<Player> findByNameLikeAndVersionOrderByName(String name, int version);

    @Query("SELECT p FROM Player p " +
            "JOIN p.clubMemberships c " +
            "ORDER BY p.id, c.club.id")
    Page<Player> findAllOrderbyPlayerAndClub(Pageable page);
}
