package com.matthew.fakeinsta.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.matthew.fakeinsta.models.Picture;
import com.matthew.fakeinsta.models.User;

@Repository
public interface TimelineRepository extends JpaRepository<Picture, Long>{
	@Query(value="SELECT p FROM Picture p WHERE p.user = :user OR p.user IN(SELECT f FROM User u JOIN u.followers f WHERE u = :user) order by p.createdAt desc")
	List<Picture> findByPictureFollower(@Param("user") User user);
}
