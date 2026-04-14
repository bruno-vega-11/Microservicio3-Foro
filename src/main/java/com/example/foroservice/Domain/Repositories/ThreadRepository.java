package com.example.foroservice.Domain.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.foroservice.Domain.Entities.ForumThread;

import java.util.List;

@Repository
public interface ThreadRepository extends MongoRepository<ForumThread, String> {
    List<ForumThread> findByMovieId(String movideId);
    List<ForumThread> findByUserId(String userId);
}
