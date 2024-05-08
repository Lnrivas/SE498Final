package com.se498.chat.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MessageTest {

    @Test
    void testChatMessageGettersAndSetters() {
        // Given
        String messageId = "123";
        String username = "user123";
        String messageText = "Hello, World!";
        int seed = 42;

        // When
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setMessageId(messageId);
        chatMessage.setUsername(username);
        chatMessage.setMessageText(messageText);
        chatMessage.setSeed(seed);

        // Then
        assertEquals(messageId, chatMessage.getMessageId());
        assertEquals(username, chatMessage.getUsername());
        assertEquals(messageText, chatMessage.getMessageText());
        assertEquals(seed, chatMessage.getSeed());
    }

    @Test
    void testChatMessageToString() {
        // Given
        String messageId = "123";
        String username = "user123";
        String messageText = "Hello, World!";
        int seed = 42;

        // When
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setMessageId(messageId);
        chatMessage.setUsername(username);
        chatMessage.setMessageText(messageText);
        chatMessage.setSeed(seed);

        // Then
        String expectedToString = "ChatMessage(" +
                "messageId=" + messageId +
                ", username=" + username +
                ", messageText=" + messageText +
                ", seed=" + seed +
                ')';
        assertEquals(expectedToString, chatMessage.toString());
    }

    @Test
    void testSimpleMessageGettersAndSetters() {
        // Given
        String role = "user";
        String content = "Hello, World!";

        // When
        SimpleMessage simpleMessage = new SimpleMessage();
        simpleMessage.setRole(role);
        simpleMessage.setContent(content);

        // Then
        assertEquals(role, simpleMessage.getRole());
        assertEquals(content, simpleMessage.getContent());
    }

    @Test
    void testChatRequestGettersAndSetters() {
        // Given
        String model = "model123";
        List<SimpleMessage> messages = List.of(new SimpleMessage("role1", "message1"), new SimpleMessage("role2", "message2"));
        int n = 10;
        double temperature = 0.5;
        int maxTokens = 100;
        int seed = 12345;

        // When
        ChatRequest chatRequest = new ChatRequest();
        chatRequest.setModel(model);
        chatRequest.setMessages(messages);
        chatRequest.setN(n);
        chatRequest.setTemperature(temperature);
        chatRequest.setMax_tokens(maxTokens);
        chatRequest.setSeed(seed);

        // Then
        assertEquals(model, chatRequest.getModel());
        assertEquals(messages, chatRequest.getMessages());
        assertEquals(n, chatRequest.getN());
        assertEquals(temperature, chatRequest.getTemperature());
        assertEquals(maxTokens, chatRequest.getMax_tokens());
        assertEquals(seed, chatRequest.getSeed());
    }

    @Test
    void testChatMessageSetVisualizedContent() {
        // Given
        String content = "Visualized content";
        ChatMessage chatMessage = new ChatMessage();

        // When
        chatMessage.setVisualizedContent(content);

        // Then
        assertEquals(content, chatMessage.getVisualizedContent());
    }

    @Test
    void testParticipantGettersAndSetters() {
        // Given
        String userId = "123";
        String username = "user123";
        String salt = "salt123";
        String password = "password123";
        String firstName = "John";
        String lastName = "Doe";

        // When
        Participant participant = new Participant();
        participant.setUserId(userId);
        participant.setUsername(username);
        participant.setSalt(salt);
        participant.setPassword(password);
        participant.setFirstName(firstName);
        participant.setLastName(lastName);

        // Then
        assertEquals(userId, participant.getUserId());
        assertEquals(username, participant.getUsername());
        assertEquals(salt, participant.getSalt());
        assertEquals(password, participant.getPassword());
        assertEquals(firstName, participant.getFirstName());
        assertEquals(lastName, participant.getLastName());
    }

    @Test
    void testChatChoiceGettersAndSetters() {
        // Given
        int index = 1;
        SimpleMessage message = new SimpleMessage("role", "content");

        // When
        ChatChoice chatChoice = new ChatChoice();
        chatChoice.setIndex(index);
        chatChoice.setMessage(message);

        // Then
        assertEquals(index, chatChoice.getIndex());
        assertEquals(message, chatChoice.getMessage());
    }

    @Test
    void testChatMessageDTOGettersAndSetters() {
        // Given
        String username = "user123";
        String messageText = "Hello, World!";
        String messageType = "type123";

        // When
        ChatMessageDTO chatMessageDTO = new ChatMessageDTO(username, messageText, messageType);

        // Then
        assertEquals(username, chatMessageDTO.getUsername());
        assertEquals(messageText, chatMessageDTO.getMessageText());
        assertEquals(messageType, chatMessageDTO.getMessageType());
    }

    @Test
    void testChatResponseGettersAndSetters() {
        // Given
        List<ChatChoice> choices = List.of(new ChatChoice(1, new SimpleMessage("role", "content")));

        // When
        ChatResponse chatResponse = new ChatResponse();
        chatResponse.setChoices(choices);

        // Then
        assertEquals(choices, chatResponse.getChoices());
    }
}
