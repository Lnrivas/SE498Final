package com.se498.chat.service;

import com.se498.chat.model.ChatMessage;
import com.se498.chat.model.Image;
import com.se498.chat.repository.FakeImageRepository;
import com.se498.chat.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    AIService aiService;

    @Autowired
    FakeImageRepository fakeImageRepository;

    private final int seed = (int) (Math.random() * Integer.MAX_VALUE);

    public ChatMessage addMessage(ChatMessage message) {

        // Save original message in the database
        ChatMessage savedMessage = messageRepository.save(message);

        // Call AI service to visualize original message
        String visualizedMessage = aiService.visualizeMessage(message.getMessageText());

        // Save original message visualization in the database
        savedMessage.setVisualizedContent(visualizedMessage);
        messageRepository.save(savedMessage);

        // Call AI service to get response to the message
        String response = aiService.askQuestion(seed, message.getUsername(), message.getMessageText(), null);

        // Save response in the database
        ChatMessage responseMessage = new ChatMessage();
        responseMessage.setUsername("AI");
        responseMessage.setMessageText(response);
        responseMessage.setSeed(seed);
        ChatMessage savedResponseMessage = messageRepository.save(responseMessage);

        // Call AI service to visualize response
        String visualizedResponse = aiService.visualizeMessage(response);

        // Save visualized response in the database
        savedResponseMessage.setVisualizedContent(visualizedResponse);
        messageRepository.save(savedResponseMessage);

        return savedMessage;
    }

    public List<ChatMessage> getChatMessages() {
        return messageRepository.findBySeed(seed);
    }

    public List<Image> getChatImages() {
        Iterable<Image> iterable = fakeImageRepository.findAll();
        List<Image> imageList = new ArrayList<>();
        iterable.forEach(imageList::add);
        return imageList;
    }

    public ChatMessage getMessage(String id){
        Optional<ChatMessage> optionalMessage = messageRepository.findById(id);
        return optionalMessage.orElse(null);
    }
}
