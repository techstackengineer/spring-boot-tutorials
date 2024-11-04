package com.techstackengineer.springboot.tutorials.searchapi.service;

import com.techstackengineer.springboot.tutorials.searchapi.model.RequestCriteria;
import com.techstackengineer.springboot.tutorials.searchapi.repository.Tutorial;
import com.techstackengineer.springboot.tutorials.searchapi.repository.TutorialRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class TutorialServiceTest {

    @Mock
    private TutorialRepository tutorialRepository;
    @InjectMocks
    private TutorialService tutorialService;

    private static PageImpl page;

    @BeforeAll
    public static void setUp() {
        Tutorial tutorial1 = new Tutorial(0001L, "Java Basics", "Introduction to Java programming language.", "Java", "2024-11-03");
        Tutorial tutorial2 = new Tutorial(0002L, "Spring Framework", "Guide to the Spring framework for enterprise applications.", "Spring", "2024-11-03");
        page = new PageImpl<>(List.of(tutorial1, tutorial2));
    }

    @Test
    void testFindAllTutorials() {
        Mockito.when(tutorialRepository.findAll(ArgumentMatchers.any(Pageable.class))).thenReturn(page);
        RequestCriteria requestCriteria = new RequestCriteria(null, 0, 10, "title", "ASC", null, null);
        Page<Tutorial> pageTutorial =  tutorialService.findTutorialsByPagingAndSorting(requestCriteria);
        assertNotNull(pageTutorial);
        assertNotNull(pageTutorial.getContent());
        assertEquals(1, pageTutorial.getTotalPages());
        assertEquals(2, pageTutorial.getTotalElements());
    }
}