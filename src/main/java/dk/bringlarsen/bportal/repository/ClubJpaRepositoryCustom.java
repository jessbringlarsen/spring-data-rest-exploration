package dk.bringlarsen.bportal.repository;

import dk.bringlarsen.bportal.model.Club;

import java.sql.SQLException;
import java.util.List;

public interface ClubJpaRepositoryCustom {

    List<Club> findByName(String name) throws SQLException;
}
