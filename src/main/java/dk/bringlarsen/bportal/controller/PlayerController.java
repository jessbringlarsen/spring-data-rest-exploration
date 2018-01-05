package dk.bringlarsen.bportal.controller;

import dk.bringlarsen.bportal.model.Player;
import dk.bringlarsen.bportal.model.PlayerSummary;
import dk.bringlarsen.bportal.repository.PlayerJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.config.EnableEntityLinks;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@EnableEntityLinks // Gør at man kan linke til en resource via repository
@ExposesResourceFor(Player.class)
@RepositoryRestController
public class PlayerController {

    private final PlayerJpaRepository repository;

    @Autowired
    private final EntityLinks entityLinks;

    @Autowired
    public PlayerController(PlayerJpaRepository repository, EntityLinks entityLinks) {
        this.repository = repository;
        this.entityLinks = entityLinks;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/players")
    @ResponseBody
    public HttpEntity<PagedResources<PlayerSummary>> getMatches(Pageable pageable) {
        Page<Player> page = repository.findAll(pageable);

        List<PlayerSummary> playerSummaryList = new ArrayList<>();
        for (Player player : page) {
            PlayerSummary playerSummary = new PlayerSummary(player.getName());

            playerSummary.add(entityLinks.linkToSingleResource(Player.class, player.getId()).withSelfRel());
            playerSummaryList.add(playerSummary);
        }
        PagedResources.PageMetadata pageMetadata = new PagedResources.PageMetadata(pageable.getPageSize(), pageable.getPageNumber(), 1000, 10);
       // entityLinks.linkToCollectionResource(PlayerSummary.class)
        PagedResources<PlayerSummary> pagedResources = new PagedResources<>(playerSummaryList, pageMetadata);
        return ResponseEntity.ok(pagedResources);
    }
}
