package com.techstackengineer.springboot.tutorials.searchapi.repository;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tutorials")
public class Tutorial {
    @Id
    private Long id;
    private String title;
    private String description;
    private String category;
    private LocalDate publishDate;
}
