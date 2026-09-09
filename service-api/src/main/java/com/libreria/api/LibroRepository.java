package com.libreria.api;

import com.libreria.api.Models.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    List<Libro> findByGenere(Genere genere);
    List<Libro> findByTitoloContainingIgnoreCase(String titolo);
    List<Libro> findByAutoreContainingIgnoreCase(String autore);
    List<Libro> findByScaffaleId(Long scaffaleId);
    long countByScaffaleId(Long scaffaleId);
}