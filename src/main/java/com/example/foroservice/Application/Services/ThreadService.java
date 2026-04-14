package com.example.foroservice.Application.Services;

import com.example.foroservice.Domain.Entities.ForumThread;
import com.example.foroservice.Domain.Repositories.ThreadRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ThreadService {

    private final ThreadRepository threadRepository;

    public List<ForumThread> getAll(){
        return threadRepository.findAll();
    }

    public ForumThread getById(String id){
        return threadRepository.findById(id).orElseThrow(()->new RuntimeException("Thread not found"));
    }

    public List<ForumThread> getByMovieId(String movieId){
        return threadRepository.findByMovieId(movieId);
    }

    public ForumThread create(ForumThread thread){
        thread.setDate(LocalDateTime.now());
        thread.setVotes(0);
        return threadRepository.save(thread);
    }

    public void delete(String id){
        if (!threadRepository.existsById(id)){
            throw new RuntimeException("Thread not found");
        }
        threadRepository.deleteById(id);
    }
}
