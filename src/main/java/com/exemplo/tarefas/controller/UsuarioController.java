package com.exemplo.tarefas.controller;

import com.exemplo.tarefas.model.Usuario;
import com.exemplo.tarefas.repository.UsuarioRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // GET - lista de usuários
    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    // POST - cria novo usuário
    @PostMapping
    public Usuario criarUsuario(@Valid @RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // GET por código
    @GetMapping("/{codigo}")
    public Usuario buscarPorCodigo(@PathVariable Long codigo) {
        return usuarioRepository.findById(codigo).orElse(null);
    }
}
