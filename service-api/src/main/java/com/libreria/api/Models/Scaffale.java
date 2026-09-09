package com.libreria.api.Models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "scaffali")
public class Scaffale {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private int capienzaMassima;

    @OneToMany(mappedBy = "scaffale", fetch = FetchType.LAZY)
    private List<Libro> libri = new ArrayList<>();

    public Scaffale() {}

    public Scaffale(int capienzaMassima) {
        this.capienzaMassima = capienzaMassima;
    }

    public Long getId() { return id; }

    public int getCapienzaMassima() { return capienzaMassima; }
    public void setCapienzaMassima(int capienzaMassima) { this.capienzaMassima = capienzaMassima; }


    public List<Libro> getLibri() { return libri; }
}
