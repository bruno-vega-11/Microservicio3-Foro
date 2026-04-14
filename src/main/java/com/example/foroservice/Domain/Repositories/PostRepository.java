package com.example.foroservice.Domain.Repositories;

import com.example.foroservice.Domain.Entities.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post,String> {
    List<Post> findByThreadId(String threadId);
    List<Post> findByUserId(String userId);
}
