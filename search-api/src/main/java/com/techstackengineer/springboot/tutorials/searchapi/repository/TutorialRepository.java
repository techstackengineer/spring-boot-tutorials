package com.techstackengineer.springboot.tutorials.searchapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
    Page<Tutorial> findByTitleContainingIgnoreCase(String title, Pageable pageable);

    Page<Tutorial> findByTitleContainingIgnoreCaseAndCategoryIgnoreCase(String title, String category,
                                                                        Pageable pageable);
    Page<Tutorial> findByCategoryIgnoreCase(String category, Pageable pageable);

}
