package com.learning.learningspring.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.learning.learningspring.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
  Optional<User> findByName(String name); 
  Integer countByName(String name);
  @Query(value = "select * from user where name = ?1", nativeQuery = true)
  User findBySomeConstraintSpringCantParse(String name);
}