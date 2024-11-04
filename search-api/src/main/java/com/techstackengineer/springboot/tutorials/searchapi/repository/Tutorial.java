package com.techstackengineer.springboot.tutorials.searchapi.repository;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tutorials")
public class Tutorial {
    @Id
    private Long id;
    private String title;
    private String description;
    private String category;
    private String publishedDate;

    public Tutorial() {
    }

    public Tutorial(Long id, String title, String description, String category, String publishedDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.category = category;
        this.publishedDate = publishedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }
}
