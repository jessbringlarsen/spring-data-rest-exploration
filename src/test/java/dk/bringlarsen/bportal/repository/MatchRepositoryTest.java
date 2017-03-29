package dk.bringlarsen.bportal.repository;

import dk.bringlarsen.bportal.model.Match;
import dk.bringlarsen.bportal.model.Player;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class MatchRepositoryTest extends AbstractBaseRepositoryTest {

    @Autowired
    private MatchJpaRepository jpaRepository;

    @Autowired
    private EntityManager entityManager;

    @Test
    public void testPersistPlayerWithClub() {
        Player player1 = new Player()
                .setName("Samsonov");

        Player player2 = new Player()
                .setName("Waldner");

        Match match = new Match()
                .setPlayer1(player1)
                .setPlayer2(player2)
                .setWhen(LocalDateTime.now());

        Match result = jpaRepository.saveAndFlush(match);
        assertThat(result.getId(), is(notNullValue()));
    }
}
