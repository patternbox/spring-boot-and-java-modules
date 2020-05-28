package com.patternbox.restdata;

import org.springframework.data.repository.query.Param;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PersonRestRepo extends CrudRepository<Person, Long> {

	List<Person> findByName(@Param("name") String name);
	
	@Query("SELECT p FROM Person p WHERE p.name LIKE %:name%")
	List<Person> findByNameLike(@Param("name") String name);
	
}
