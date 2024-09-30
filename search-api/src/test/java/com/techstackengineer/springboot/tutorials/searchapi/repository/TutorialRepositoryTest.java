package com.techstackengineer.springboot.tutorials.searchapi.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class TutorialRepositoryTest {
    @Autowired
    private TutorialRepository tutorialRepository;

    @Test
    void testFindByTitleContainingIgnoreCase() {
        PageRequest pageRequest = PageRequest.of(0, 10);
        Page<Tutorial> pageTutorial = tutorialRepository.findByTitleContainingIgnoreCase("Java", pageRequest);
        assertNotNull(pageTutorial);
        assertNotNull(pageTutorial.getContent());
        assertEquals(2, pageTutorial.getTotalPages());
        assertEquals(13, pageTutorial.getTotalElements());
    }

    @Test
    void testFindByTitleContainingIgnoreCaseAndCategoryIgnoreCase() {
        PageRequest pageRequest = PageRequest.of(0, 10);
        Page<Tutorial> pageTutorial = tutorialRepository.findByTitleContainingIgnoreCaseAndCategoryIgnoreCase("Java", "MicroServices", pageRequest);
        assertNotNull(pageTutorial);
        assertNotNull(pageTutorial.getContent());
        assertEquals(1, pageTutorial.getTotalPages());
        assertEquals(1, pageTutorial.getTotalElements());
    }

    @Test
    void testFindByCategoryIgnoreCase() {
        PageRequest pageRequest = PageRequest.of(0, 10);
        Page<Tutorial> pageTutorial = tutorialRepository.findByCategoryIgnoreCase("API Development", pageRequest);
        assertNotNull(pageTutorial);
        assertNotNull(pageTutorial.getContent());
        assertEquals(1, pageTutorial.getTotalPages());
        assertEquals(6, pageTutorial.getTotalElements());
    }
}