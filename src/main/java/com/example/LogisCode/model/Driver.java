package com.example.LogisCode.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor

@Table(name = "drivers")
@Entity
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(nullable = false)
    private boolean deleted = false;

    // Getter para el id
    public Long getId() {
        return id;
    }

    // Setter para el id
    public void setId(Long id) {
        this.id = id;
    }

    // Getter para el nombre
    public String getName() {
        return name;
    }

    // Setter para el nombre
    public void setName(String name) {
        this.name = name;
    }

    // Getter para el deleted
    public boolean isDeleted() {
        return deleted;
    }

    // Setter para el deleted
    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
