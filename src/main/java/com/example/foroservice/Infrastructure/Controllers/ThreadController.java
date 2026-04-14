package com.example.foroservice.Infrastructure.Controllers;

import com.example.foroservice.Application.Services.ThreadService;
import com.example.foroservice.Domain.Entities.ForumThread;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/threads")
@RequiredArgsConstructor
public class ThreadController {

    private final ThreadService threadService;

    @GetMapping
    public ResponseEntity<List<ForumThread>> getAll() {
        return ResponseEntity.ok(threadService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ForumThread> getById(@PathVariable String id) {
        return ResponseEntity.ok(threadService.getById(id));
    }

    @GetMapping("/movie/{movieId}")
    public ResponseEntity<List<ForumThread>> getByMovieId(@PathVariable String movieId) {
        return ResponseEntity.ok(threadService.getByMovieId(movieId));
    }

    @PostMapping
    public ResponseEntity<ForumThread> create(@RequestBody ForumThread thread) {
        return ResponseEntity.status(HttpStatus.CREATED).body(threadService.create(thread));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ForumThread> delete(@PathVariable String id) {
        threadService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
