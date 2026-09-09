package com.libreria.api;

import com.libreria.api.Models.Scaffale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScaffaleRepository extends JpaRepository<Scaffale, Long> {
}