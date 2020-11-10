package com.matthew.weddings.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.matthew.weddings.models.Wedding;

@Repository
public interface WeddingRepository extends CrudRepository<Wedding, Long> {
	List<Wedding> findAll();
}
