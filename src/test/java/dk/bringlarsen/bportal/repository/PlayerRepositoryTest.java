package dk.bringlarsen.bportal.repository;

import dk.bringlarsen.bportal.model.Club;
import dk.bringlarsen.bportal.model.ClubMembership;
import dk.bringlarsen.bportal.model.Player;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PlayerRepositoryTest extends AbstractBaseRepositoryTest {

    @Autowired
    private PlayerJpaRepository playerJpaRepository;

    @Autowired
    private EntityManager entityManager;

    private static final LocalDate MEMBER_FROM = LocalDate.of(2000, Month.JANUARY, 1);
    private static final LocalDate MEMBER_TO = LocalDate.of(2015, Month.JANUARY, 1);

    @Test
    public void testPersistPlayerWithClub() {
        Player player = new Player()
                .setName("player");

        ClubMembership clubMembership = new ClubMembership()
                .setClub(new Club()
                        .setName("club"))
                .setPlayer(player)
                .setMemberFrom(MEMBER_FROM)
                .setMemberTo(MEMBER_TO);

        player.setClubMemberships(Collections.singletonList(clubMembership));

        Long id = playerJpaRepository.saveAndFlush(player).getId();
        entityManager.clear();

        List<ClubMembership> clubMemberships = playerJpaRepository.findOne(id).getClubMemberships();
        ClubMembership membership = clubMemberships.get(0);

        assertThat(clubMemberships.size(), is(1));
        assertThat(membership.getClub().getName(), is("club"));
        assertThat(membership.getMemberFrom(), is(MEMBER_FROM));
        assertThat(membership.getMemberTo(), is(MEMBER_TO));
        assertThat(membership.getPlayer(), is(player));
    }

    @Test
    public void testCustomFinderMethod() {
        List<Player> result = playerJpaRepository.findByName("Jan");

        assertThat(result.size(), is(1));
        assertThat(result.get(0).getName(), is("Jan"));
    }

    @Test
    public void testProxyFinderMethod() {
        List<Player> result = playerJpaRepository.findByNameLikeAndVersionOrderByName("Jan", 1);

        assertThat(result.size(), is(1));
        assertThat(result.get(0).getName(), is("Jan"));
    }

    @Test
    public void testOrderby() {
        List<Player> result = playerJpaRepository.findAllOrderbyPlayerAndClub();

        assertThat(result.size(), is(3));
    }
}
