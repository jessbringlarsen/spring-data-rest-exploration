package dk.bringlarsen.bportal.repository;

import dk.bringlarsen.bportal.model.Club;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ClubJpaRepositoryTest extends AbstractBaseRepositoryTest {

    @Autowired
    private ClubJpaRepository clubJpaRepository;

    @Test
    public void testPersistClub() {
        Club club = new Club()
                .setName("jebla");
        Club saved = clubJpaRepository.saveAndFlush(club);

       assertThat(clubJpaRepository.exists(saved.getId()), is(true));
    }
}