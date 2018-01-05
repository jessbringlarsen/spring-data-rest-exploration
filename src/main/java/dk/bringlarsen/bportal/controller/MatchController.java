package dk.bringlarsen.bportal.controller;

import dk.bringlarsen.bportal.model.Match;
import dk.bringlarsen.bportal.repository.MatchJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RepositoryRestController
public class MatchController {

    private final MatchJpaRepository repository;

    @Autowired
    public MatchController(MatchJpaRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/matches")
    public @ResponseBody ResponseEntity<?> getMatches(Pageable pageable) {
        Page<Match> page = repository.findAll(pageable);
        Resources<Match> resources = new Resources<>(page);

        return ResponseEntity.ok(resources);
    }
}
