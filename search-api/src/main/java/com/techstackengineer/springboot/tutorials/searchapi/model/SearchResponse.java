package com.techstackengineer.springboot.tutorials.searchapi.model;

import com.techstackengineer.springboot.tutorials.searchapi.repository.Tutorial;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchResponse {
    private List<Tutorial> tutorials;
    private int totalPages;
    private long totalItems;
    private int currentPage;
}
