package com.exemplo.tarefas.controller;

import com.exemplo.tarefas.model.Categoria;
import com.exemplo.tarefas.repository.CategoriaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    // GET - lista categorias
    @GetMapping
    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    // POST - cria nova categoria
    @PostMapping
    public Categoria criarCategoria(@RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    // GET por código
    @GetMapping("/{codigo}")
    public Categoria buscarPorCodigo(@PathVariable Long codigo) {
        return categoriaRepository.findById(codigo).orElse(null);
    }
}
