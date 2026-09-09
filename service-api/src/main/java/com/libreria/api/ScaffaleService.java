package com.libreria.api;

import com.libreria.api.Models.Scaffale;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ScaffaleService {

    private final ScaffaleRepository scaffaleRepository;

    public ScaffaleService(ScaffaleRepository scaffaleRepository) {
        this.scaffaleRepository = scaffaleRepository;
    }

    public List<Scaffale> getTuttiScaffali() {
        return scaffaleRepository.findAll();
    }

    public Scaffale getScaffaleById(Long id) {
        return scaffaleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Scaffale non trovato: " + id));
    }

    public Scaffale creaScaffale(Scaffale scaffale) {
        return scaffaleRepository.save(scaffale);
    }

    public void eliminaScaffale(Long id) {
        Scaffale scaffale = getScaffaleById(id);
        if (!scaffale.getLibri().isEmpty()) {
            throw new IllegalStateException("Scaffale non vuoto: sposta o elimina prima i libri contenuti");
        }
        scaffaleRepository.deleteById(id);
    }

    public long contaTuttiScaffali() {
        return scaffaleRepository.count();
    }
}