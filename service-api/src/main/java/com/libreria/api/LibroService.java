package com.libreria.api;

import com.libreria.api.Models.Libro;
import com.libreria.api.Models.Scaffale;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class LibroService {

    private final LibroRepository libroRepository;
    private final ScaffaleRepository scaffaleRepository;

    public LibroService(LibroRepository libroRepository, ScaffaleRepository scaffaleRepository) {
        this.libroRepository = libroRepository;
        this.scaffaleRepository = scaffaleRepository;
    }

    public List<Libro> getTuttiLibri() {
        return libroRepository.findAll();
    }

    public Libro getLibroById(Long id) {
        return libroRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Libro non trovato: " + id));
    }

    public Libro creaLibro(Long scaffaleId, Libro libro) {
        Scaffale scaffale = scaffaleRepository.findById(scaffaleId)
                .orElseThrow(() -> new NoSuchElementException("Scaffale non trovato: " + scaffaleId));

        if (scaffale.getLibri().size() >= scaffale.getCapienzaMassima()) {
            throw new IllegalStateException("Scaffale pieno");
        }

        libro.setScaffale(scaffale);
        return libroRepository.save(libro);
    }

    public Libro aggiornaLibro(Long id, Libro libroAggiornato) {
        Libro libro = getLibroById(id);
        libro.setTitolo(libroAggiornato.getTitolo());
        libro.setAutore(libroAggiornato.getAutore());
        libro.setGenere(libroAggiornato.getGenere());
        return libroRepository.save(libro);
    }

    public void eliminaLibro(Long id) {
        if (!libroRepository.existsById(id)) {
            throw new NoSuchElementException("Libro non trovato: " + id);
        }
        libroRepository.deleteById(id);
    }

    public List<Libro> cercaPerGenere(Genere genere) {
        return libroRepository.findByGenere(genere);
    }

    public List<Libro> cercaPerTitolo(String titolo) {
        return libroRepository.findByTitoloContainingIgnoreCase(titolo);
    }

    public List<Libro> cercaPerAutore(String autore) {
        return libroRepository.findByAutoreContainingIgnoreCase(autore);
    }

    public List<Libro> getLibriInScaffale(Long scaffaleId) {
        return libroRepository.findByScaffaleId(scaffaleId);
    }

    public long contaLibriInScaffale(Long scaffaleId) {
        return libroRepository.countByScaffaleId(scaffaleId);
    }

    public long contaTuttiLibri() {
        return libroRepository.count();
    }
}