package com.libreria.api.dto;

import com.libreria.api.Genere;
import com.libreria.api.Models.Libro;

public class LibroDTO {
    private Long id;
    private String titolo;
    private String autore;
    private Genere genere;
    private Long scaffaleId;

    public LibroDTO() {}

    public LibroDTO(Long id, String titolo, String autore, Genere genere, Long scaffaleId) {
        this.id = id;
        this.titolo = titolo;
        this.autore = autore;
        this.genere = genere;
        this.scaffaleId = scaffaleId;
    }

    public static LibroDTO from(Libro libro) {
        Long scaffaleId = libro.getScaffale() != null ? libro.getScaffale().getId() : null;
        return new LibroDTO(libro.getId(), libro.getTitolo(), libro.getAutore(), libro.getGenere(), scaffaleId);
    }

    public Long getId() { return id; }
    public String getTitolo() { return titolo; }
    public String getAutore() { return autore; }
    public Genere getGenere() { return genere; }
    public Long getScaffaleId() { return scaffaleId; }
}