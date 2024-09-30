package com.techstackengineer.springboot.tutorials.searchapi.service;

import com.techstackengineer.springboot.tutorials.searchapi.repository.Tutorial;
import com.techstackengineer.springboot.tutorials.searchapi.repository.TutorialRepository;
import com.techstackengineer.springboot.tutorials.searchapi.model.RequestCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class TutorialService {
    @Autowired
    TutorialRepository tutorialRepository;

    /**
     *
     * @param requestCriteria
     * @return
     */
    public Page<Tutorial> findTutorialsByPagingAndSorting(RequestCriteria requestCriteria) {
        Page<Tutorial> tutorialPage;
        PageRequest pageRequest = PageRequest.of(requestCriteria.getPage(), requestCriteria.getSize());
        if(requestCriteria.getSort() != null) {
            Sort.Direction direction = Sort.Direction.ASC;
            if ("DSC".equalsIgnoreCase(requestCriteria.getSortOrder())) {
                direction = Sort.Direction.DESC;
            }
            pageRequest = PageRequest.of(requestCriteria.getPage(), requestCriteria.getSize(),
                    Sort.by(direction, requestCriteria.getSort()));
        }
        String searchQuery = requestCriteria.getQuery();
        String category = requestCriteria.getCategory();
        boolean categoryFilter = "Yes".equalsIgnoreCase(requestCriteria.getFilter()) && category != null;

        if(searchQuery != null) {
            if(categoryFilter) {
                tutorialPage = tutorialRepository.findByTitleContainingIgnoreCaseAndCategoryIgnoreCase(searchQuery, category, pageRequest);
            } else {
                tutorialPage = tutorialRepository.findByTitleContainingIgnoreCase(searchQuery, pageRequest);
            }
        } else {
            if(categoryFilter) {
                tutorialPage = tutorialRepository.findByCategoryIgnoreCase(category, pageRequest);
            } else {
                tutorialPage = tutorialRepository.findAll(pageRequest);
            }
        }
        return tutorialPage;
    }

}
