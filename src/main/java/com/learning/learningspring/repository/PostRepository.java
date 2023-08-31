package com.learning.learningspring.repository;


import org.springframework.data.repository.CrudRepository;

import com.learning.learningspring.entity.Post;

public interface PostRepository extends CrudRepository<Post, Integer>{

}