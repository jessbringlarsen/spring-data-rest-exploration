package com.systematic.cphdev.repository;

import com.systematic.cphdev.model.Actor;
import com.systematic.cphdev.model.StarWarsMovie;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ActorRepository extends PagingAndSortingRepository<Actor, Integer> {
}
