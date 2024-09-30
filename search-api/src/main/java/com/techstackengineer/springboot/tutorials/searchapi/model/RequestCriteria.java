package com.techstackengineer.springboot.tutorials.searchapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RequestCriteria {
    private String query;
    private int page;
    private int size;
    private String sort;
    private String sortOrder;
    private String filter;
    private String category;
}
