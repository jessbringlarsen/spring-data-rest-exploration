package dk.bringlarsen.bportal.repository;

import dk.bringlarsen.bportal.model.Club;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

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

        // flush and clean
       assertThat(clubJpaRepository.getOne(saved.getId()).getId(), is(saved.getId()));
    }

    @Test
    public void testFindByNameIsNotNull() {
        assertThat(clubJpaRepository.findByNameIsNotNull(null).getTotalElements(), greaterThan(1L));
    }

    @Test
    public void testFindByNameEndingWith() {
        assertThat(clubJpaRepository.findByNameEndingWith("BTK", null).getTotalElements(), greaterThan(1L));
    }

    @Test
    public void testCustomFinderMethod() throws SQLException {
        List<Club> result = clubJpaRepository.findByName("BBC");

        assertThat(result.get(0).getName(), is("BBC"));
    }
}