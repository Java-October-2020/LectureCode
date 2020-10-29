package com.matthew.records.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.matthew.records.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long>{

}
