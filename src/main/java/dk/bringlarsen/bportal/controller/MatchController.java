package dk.bringlarsen.bportal.controller;

import dk.bringlarsen.bportal.model.Match;
import dk.bringlarsen.bportal.repository.MatchJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RepositoryRestController
public class MatchController {

    private final MatchJpaRepository repository;
    private final PagedResourcesAssembler assembler;

    @Autowired
    public MatchController(MatchJpaRepository repository, PagedResourcesAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/matches")
    public HttpEntity<PagedResources<Match>> getMatches(Pageable pageable) {
        Page<Match> page = repository.findAll(pageable);

        return new ResponseEntity(assembler.toResource(page), HttpStatus.OK);
    }
}
