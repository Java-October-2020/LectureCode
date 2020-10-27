package com.matthew.records.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.matthew.records.models.Label;

@Repository
public interface LabelRepository extends CrudRepository<Label, Long>{

}
