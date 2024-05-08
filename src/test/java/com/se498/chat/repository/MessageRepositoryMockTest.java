package com.se498.chat.repository;

import com.se498.chat.model.ChatMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageRepositoryMockTest {

    @InjectMocks
    private FakeMessageRepository messageRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindAll() {
        List<ChatMessage> messages = messageRepository.findAll();
        assertEquals(2, messages.size());
        assertEquals("1", messages.get(0).getMessageId());
        assertEquals("Hello", messages.get(0).getMessageText());
        assertEquals(123, messages.get(0).getSeed());
        assertEquals("2", messages.get(1).getMessageId());
        assertEquals("World", messages.get(1).getMessageText());
        assertEquals(123, messages.get(1).getSeed());
    }
}
