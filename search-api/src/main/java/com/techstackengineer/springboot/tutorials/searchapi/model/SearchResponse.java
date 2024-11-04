package com.techstackengineer.springboot.tutorials.searchapi.model;

import com.techstackengineer.springboot.tutorials.searchapi.repository.Tutorial;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class SearchResponse {
    private List<Tutorial> tutorials;
    private int totalPages;
    private long totalItems;
    private int currentPage;

    public SearchResponse(List<Tutorial> tutorials, int totalPages, long totalItems, int currentPage) {
        this.tutorials = tutorials;
        this.totalPages = totalPages;
        this.totalItems = totalItems;
        this.currentPage = currentPage;
    }

    public List<Tutorial> getTutorials() {
        return tutorials;
    }

    public void setTutorials(List<Tutorial> tutorials) {
        this.tutorials = tutorials;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(long totalItems) {
        this.totalItems = totalItems;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
}
