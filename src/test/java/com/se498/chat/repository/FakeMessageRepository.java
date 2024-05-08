package com.se498.chat.repository;

import com.se498.chat.model.ChatMessage;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FakeMessageRepository {

    private final List<ChatMessage> messages;

    public FakeMessageRepository() {
        this.messages = new ArrayList<>();
        messages.add(new ChatMessage("1", "user1", "Hello", 123));
        messages.add(new ChatMessage("2", "user2", "World", 123));
    }

    public List<ChatMessage> findAll() {
        return messages;
    }

    public ChatMessage findById(String id) {
        return messages.stream()
                .filter(message -> message.getMessageId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void save(ChatMessage message) {
        messages.add(message);
    }

    public void delete(ChatMessage message) {
        messages.remove(message);
    }

    public void deleteAll() {
        messages.clear();
    }
}
