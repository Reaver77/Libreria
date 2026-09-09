package com.libreria.api.dto;

import com.libreria.api.Models.Scaffale;

import java.util.List;
import java.util.stream.Collectors;

public class ScaffaleDTO {
    private Long id;
    private int capienzaMassima;
    private List<LibroDTO> libri;

    public ScaffaleDTO() {}

    public ScaffaleDTO(Long id, int capienzaMassima, List<LibroDTO> libri) {
        this.id = id;
        this.capienzaMassima = capienzaMassima;
        this.libri = libri;
    }

    public static ScaffaleDTO from(Scaffale scaffale) {
        List<LibroDTO> libriDto = scaffale.getLibri().stream()
                .map(libro -> new LibroDTO(
                        libro.getId(), libro.getTitolo(), libro.getAutore(),
                        libro.getGenere(), scaffale.getId()))
                .collect(Collectors.toList());
        return new ScaffaleDTO(scaffale.getId(), scaffale.getCapienzaMassima(), libriDto);
    }

    public Long getId() { return id; }
    public int getCapienzaMassima() { return capienzaMassima; }
    public List<LibroDTO> getLibri() { return libri; }
}