package com.libreria.api;

import com.libreria.api.Models.Libro;
import com.libreria.api.dto.LibroDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/libri")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    public List<LibroDTO> getTuttiLibri() {
        return libroService.getTuttiLibri().stream()
                .map(LibroDTO::from)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public LibroDTO getLibro(@PathVariable Long id) {
        return LibroDTO.from(libroService.getLibroById(id));
    }

    @PostMapping("/scaffale/{scaffaleId}")
    public LibroDTO creaLibro(@PathVariable Long scaffaleId, @RequestBody Libro libro) {
        return LibroDTO.from(libroService.creaLibro(scaffaleId, libro));
    }

    @PutMapping("/{id}")
    public LibroDTO aggiornaLibro(@PathVariable Long id, @RequestBody Libro libroAggiornato) {
        return LibroDTO.from(libroService.aggiornaLibro(id, libroAggiornato));
    }

    @DeleteMapping("/{id}")
    public void eliminaLibro(@PathVariable Long id) {
        libroService.eliminaLibro(id);
    }

    @GetMapping("/genere/{genere}")
    public List<LibroDTO> cercaPerGenere(@PathVariable Genere genere) {
        return libroService.cercaPerGenere(genere).stream()
                .map(LibroDTO::from)
                .collect(Collectors.toList());
    }

    @GetMapping("/titolo/{titolo}")
    public List<LibroDTO> cercaPerTitolo(@PathVariable String titolo) {
        return libroService.cercaPerTitolo(titolo).stream()
                .map(LibroDTO::from)
                .collect(Collectors.toList());
    }

    @GetMapping("/autore/{autore}")
    public List<LibroDTO> cercaPerAutore(@PathVariable String autore) {
        return libroService.cercaPerAutore(autore).stream()
                .map(LibroDTO::from)
                .collect(Collectors.toList());
    }

    @GetMapping("/scaffale/{scaffaleId}")
    public List<LibroDTO> getLibriInScaffale(@PathVariable Long scaffaleId) {
        return libroService.getLibriInScaffale(scaffaleId).stream()
                .map(LibroDTO::from)
                .collect(Collectors.toList());
    }

    @GetMapping("/scaffale/{scaffaleId}/conteggio")
    public long contaLibriInScaffale(@PathVariable Long scaffaleId) {
        return libroService.contaLibriInScaffale(scaffaleId);
    }

    @GetMapping("/conteggio")
    public long contaTuttiLibri() {
        return libroService.contaTuttiLibri();
    }
}