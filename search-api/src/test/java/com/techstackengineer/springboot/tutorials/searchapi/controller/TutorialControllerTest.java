package com.techstackengineer.springboot.tutorials.searchapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.techstackengineer.springboot.tutorials.searchapi.model.RequestCriteria;
import com.techstackengineer.springboot.tutorials.searchapi.model.SearchResponse;
import com.techstackengineer.springboot.tutorials.searchapi.repository.Tutorial;
import com.techstackengineer.springboot.tutorials.searchapi.service.TutorialService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
public class TutorialControllerTest {
    @MockBean
    private TutorialService tutorialService;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testSearchTutorials() throws Exception {
        Tutorial tutorial1 = new Tutorial(0001L, "Java Basics", "Introduction to Java programming language.", "Java", LocalDate.now());
        Tutorial tutorial2 = new Tutorial(0002L, "Spring Framework", "Guide to the Spring framework for enterprise applications.", "Spring", LocalDate.now());
        PageImpl page = new PageImpl<>(List.of(tutorial1, tutorial2));
        when(tutorialService.findTutorialsByPagingAndSorting(any(RequestCriteria.class))).thenReturn(page);

        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1.0/tutorials/search")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        String response = mvcResult.getResponse().getContentAsString();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        SearchResponse searchResponse = objectMapper.readValue(response, SearchResponse.class);
        assertNotNull(searchResponse);
        assertNotNull(searchResponse.getTutorials());
        assertEquals(2, searchResponse.getTotalItems());
        assertEquals(1, searchResponse.getTotalPages());
        assertEquals("Java Basics", searchResponse.getTutorials().get(0).getTitle());
    }
}