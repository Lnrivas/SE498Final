package com.se498.chat.repository;

import com.se498.chat.ChatApplication;
import com.se498.chat.model.ChatMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Iterator;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = ChatApplication.class)
public class MessageRepositoryIntegrationTest {

    @Autowired
    private MessageRepository messageRepository;

    @BeforeEach
    public void setUp() {
        messageRepository.deleteAll();
    }

    @Test
    public void testFindAll() {
        // Given
        ChatMessage message = new ChatMessage(UUID.randomUUID().toString(), "Hello", "World", 123); // Assign UUID
        messageRepository.save(message);

        // When
        Iterable<ChatMessage> messages = messageRepository.findAll();
        int count = 0;
        for (ChatMessage msg : messages) {
            count++;
        }

        // Then
        assertEquals(1, count);
    }
}
