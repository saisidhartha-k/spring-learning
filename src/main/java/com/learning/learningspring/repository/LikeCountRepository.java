package com.learning.learningspring.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.learning.learningspring.entity.LikeRecord;

public interface LikeCountRepository extends RepositoryMetadataManager<LikeRecord, Integer> {
  @Query(value = "select count(*) from `like_record` where post_id = ?1", nativeQuery=true)
  Integer countByPostIdnative(Integer postId);
  
  @Query(value = "select count(*) from LikeRecord l where l.likeId.post.id = ?1")
  Integer countByPostId(Integer postId);
}