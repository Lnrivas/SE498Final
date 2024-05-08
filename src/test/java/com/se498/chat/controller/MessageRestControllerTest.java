package com.se498.chat.controller;

import com.se498.chat.model.Image;
import com.se498.chat.service.ImageService;
import com.se498.chat.service.MessageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class MessageRestControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ImageService imageService;

    @Mock
    private MessageService messageService;

    @InjectMocks
    private APIController apiController;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(apiController).build();
    }

    @Test
    public void testGetImages() throws Exception {
        List<Image> images = Arrays.asList(
                new Image("1", "Image1", "http://image1.jpg"),
                new Image("2", "Image2", "http://image2.jpg")
        );

        when(imageService.getChatImages()).thenReturn(images);

        mockMvc.perform(get("/images"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].imageId").value("1"))
                .andExpect(jsonPath("$[1].imageId").value("2"));
    }

}
