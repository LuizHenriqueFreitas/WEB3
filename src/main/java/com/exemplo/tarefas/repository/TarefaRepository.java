package com.exemplo.tarefas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.exemplo.tarefas.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
