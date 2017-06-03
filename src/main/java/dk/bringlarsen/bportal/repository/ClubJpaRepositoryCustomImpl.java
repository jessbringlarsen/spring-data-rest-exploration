package dk.bringlarsen.bportal.repository;

import dk.bringlarsen.bportal.model.Club;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.sql.SQLException;
import java.util.List;

/**
 * Spring Data rest wise these would be exposed using a custom controller where
 * a http method can be specified that support the resource. Spring data rest cannot
 * reason about that here.
 *
 * It is important that the naming of the custom repositories are correct and that finder methods
 * obey the query syntax: https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation
 */
public class ClubJpaRepositoryCustomImpl implements ClubJpaRepositoryCustom {

    @Autowired
    private EntityManager entityManager;

    public List<Club> findByName(@Param("name") String name) throws SQLException {
        TypedQuery<Club> query = entityManager.createQuery("select c from club c where c.name = :name", Club.class);
        return query.setParameter("name", name).getResultList();
    }
}
