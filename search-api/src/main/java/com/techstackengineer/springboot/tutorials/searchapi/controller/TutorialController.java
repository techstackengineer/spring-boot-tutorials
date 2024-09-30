package com.techstackengineer.springboot.tutorials.searchapi.controller;

import com.techstackengineer.springboot.tutorials.searchapi.repository.Tutorial;
import com.techstackengineer.springboot.tutorials.searchapi.model.RequestCriteria;
import com.techstackengineer.springboot.tutorials.searchapi.model.SearchResponse;
import com.techstackengineer.springboot.tutorials.searchapi.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Tutorial Controllers
 */
@RestController
@RequestMapping("/api/v1.0/tutorials")
public class TutorialController {

    @Autowired
    TutorialService tutorialService;

    /**
     *
     * @param query
     * @param page
     * @param size
     * @param sort
     * @param sortOrder
     * @return
     */
    @GetMapping("/search")
    public ResponseEntity<SearchResponse> search(@RequestParam(required = false) String query,
                                                @RequestParam(defaultValue = "0") int page,
                                                @RequestParam(defaultValue = "10") int size,
                                                @RequestParam(required = false) String sort,
                                                @RequestParam(required = false) String sortOrder,
                                                @RequestParam(required = false) String filter,
                                                @RequestParam(required = false) String category) {
        RequestCriteria requestCriteria = new RequestCriteria(query, page, size, sort, sortOrder, filter, category);
        Page<Tutorial> tutorialPage = tutorialService.findTutorialsByPagingAndSorting(requestCriteria);
        SearchResponse searchResponse = new SearchResponse(tutorialPage.getContent(), tutorialPage.getTotalPages(),
                tutorialPage.getTotalElements(), tutorialPage.getNumber());
        return new ResponseEntity<>(searchResponse, HttpStatus.OK);

    }
}
