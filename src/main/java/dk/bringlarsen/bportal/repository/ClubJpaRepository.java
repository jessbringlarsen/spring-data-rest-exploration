package dk.bringlarsen.bportal.repository;

import dk.bringlarsen.bportal.model.Club;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Example of a repository with custom finder methods. All are exposed as links in the endpoint:
 * http://localhost:8080/api/clubs/search/
 *
 */
@RepositoryRestResource
public interface ClubJpaRepository extends JpaRepository<Club, Long> {

    @RestResource(path = "nameIsNotNull", rel = "nameIsNotNull")
    Page<Club> findByNameIsNotNull(Pageable page);

    /**
     * Exposes a endpoint on the search resource to query all clubs that have a specific postfix:
     * http://localhost:8080/api/clubs/search/nameEndingWith?postFix=BTK&page=1
     *
     * Adding the {@Pageable} parameter gives the posibility to do paging and sorting:
     * http://localhost:8080/api/clubs/search/nameEndingWith?postFix=BTK&size=10&page=1&sort=name,asc
     *
     * @param postFix of club names to query
     * @param  page add support for sorting and paging
     * @return object of the type {@Page} that include the self, prev and next links.
     */
    @RestResource(path = "nameEndingWith", rel = "nameEndingWith")
    Page<Club> findByNameEndingWith(@Param("postFix") String postFix, Pageable page);
}
