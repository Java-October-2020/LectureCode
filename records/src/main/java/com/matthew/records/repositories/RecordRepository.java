package com.matthew.records.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.matthew.records.models.Record;

@Repository
public interface RecordRepository extends CrudRepository<Record, Long>{
	List<Record> findAll();
	Record findByYearGreaterThan(int num);
	

}

// C - Create
// R - Read
// U - Update
// D - Delete