package com.matthew.fakeinsta.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.matthew.fakeinsta.models.Picture;
import com.matthew.fakeinsta.models.User;

@Repository
public interface PictureRepository extends CrudRepository<Picture, Long>{
	List<Picture> findAllByUser(User user);
}
