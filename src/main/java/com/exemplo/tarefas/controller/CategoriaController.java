package com.exemplo.tarefas.controller;

import com.exemplo.tarefas.model.Categoria;
import com.exemplo.tarefas.repository.CategoriaRepository;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
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
    public Categoria criarCategoria(@Valid @RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    // GET por código
    @GetMapping("/{codigo}")
    public Categoria buscarPorCodigo(@PathVariable Long codigo) {
        return categoriaRepository.findById(codigo).orElse(null);
    }
    
 // PUT - atualizar categoria
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizarCategoria(@PathVariable Long id,
                                                        @Valid @RequestBody Categoria categoriaAtualizada) {
        return categoriaRepository.findById(id)
                .map(categoria -> {
                    categoria.setNome(categoriaAtualizada.getNome());
                    Categoria salvo = categoriaRepository.save(categoria);
                    return ResponseEntity.ok(salvo);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE - remover categoria
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable Long id) {
        return categoriaRepository.findById(id)
                .map(categoria -> {
                    categoriaRepository.delete(categoria);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
