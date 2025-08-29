package com.exemplo.tarefas.repository;

import com.exemplo.tarefas.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
