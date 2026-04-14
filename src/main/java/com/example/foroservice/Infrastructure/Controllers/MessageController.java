package com.example.foroservice.Infrastructure.Controllers;

import com.example.foroservice.Application.Services.MessageService;
import com.example.foroservice.Domain.Entities.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @GetMapping("/thread/{threadId}")
    public ResponseEntity<List<Message>> getByThreadId(@PathVariable String threadId) {
        return ResponseEntity.ok(messageService.getByThreadId(threadId));
    }

    @PostMapping
    public ResponseEntity<Message> create(@RequestBody Message message) {
        return ResponseEntity.status(HttpStatus.CREATED).body(messageService.create(message));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        messageService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
