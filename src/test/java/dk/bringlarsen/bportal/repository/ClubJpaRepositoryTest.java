package dk.bringlarsen.bportal.repository;

import dk.bringlarsen.bportal.model.Club;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
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

    @Test
    public void testFindByNameIsNotNull() {
        assertThat(clubJpaRepository.findByNameIsNotNull(null).getTotalElements(), greaterThan(1L));
    }

    @Test
    public void testFindByNameEndingWith() {
        assertThat(clubJpaRepository.findByNameEndingWith("BTK", null).getTotalElements(), greaterThan(1L));
    }
}