package com.techstackengineer.springboot.tutorials.searchapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

public class RequestCriteria {
    private String query;
    private int page;
    private int size;
    private String sort;
    private String sortOrder;
    private String filter;
    private String category;

    public RequestCriteria(String query, int page, int size, String sort, String sortOrder, String filter, String category) {
        this.query = query;
        this.page = page;
        this.size = size;
        this.sort = sort;
        this.sortOrder = sortOrder;
        this.filter = filter;
        this.category = category;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getFilter() {
        return filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
