package com.se498.chat.model;

import lombok.*;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class ChatMessage {

    @Id
    private String messageId;
    private String username;
    private String messageText;
    private int seed;

    public ChatMessage() {
        this.messageId = UUID.randomUUID().toString();
        this.username = "";
        this.messageText = "";
        this.seed = 0;
    }

    public ChatMessage(String username, String messageText, int seed) {
        this.messageId = UUID.randomUUID().toString();
        this.username = username;
        this.messageText = messageText;
        this.seed = seed;
    }

    public void setVisualizedContent(String content) {
        // No implementation needed
    }

    public String getVisualizedContent() {
        return "Visualized content";
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}
