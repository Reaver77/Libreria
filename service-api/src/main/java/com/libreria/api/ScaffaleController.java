package com.libreria.api;

import com.libreria.api.Models.Scaffale;
import com.libreria.api.dto.ScaffaleDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/scaffali")
public class ScaffaleController {

    private final ScaffaleService scaffaleService;

    public ScaffaleController(ScaffaleService scaffaleService) {
        this.scaffaleService = scaffaleService;
    }

    @GetMapping
    public List<ScaffaleDTO> getTuttiScaffali() {
        return scaffaleService.getTuttiScaffali().stream()
                .map(ScaffaleDTO::from)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ScaffaleDTO getScaffale(@PathVariable Long id) {
        return ScaffaleDTO.from(scaffaleService.getScaffaleById(id));
    }

    @PostMapping
    public ScaffaleDTO creaScaffale(@RequestBody Scaffale scaffale) {
        return ScaffaleDTO.from(scaffaleService.creaScaffale(scaffale));
    }

    @DeleteMapping("/{id}")
    public void eliminaScaffale(@PathVariable Long id) {
        scaffaleService.eliminaScaffale(id);
    }

    @GetMapping("/conteggio")
    public long contaTuttiScaffali() {
        return scaffaleService.contaTuttiScaffali();
    }
}