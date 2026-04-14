package com.example.foroservice.Application.Services;

import com.example.foroservice.Domain.Entities.Message;
import com.example.foroservice.Domain.Repositories.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    public List<Message> getByThreadId(String threadId){
        return messageRepository.findByThreadId(threadId);
    }

    public Message create(Message message) {
        message.setTimestamp(LocalDateTime.now());
        return messageRepository.save(message);
    }

    public void delete(String id){
        if (!messageRepository.existsById(id)) {
            throw new RuntimeException("No se encontro el message con el id " + id);
        }
        messageRepository.deleteById(id);
    }
}
