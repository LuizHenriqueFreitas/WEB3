package com.exemplo.tarefas.controller;

import com.exemplo.tarefas.model.Usuario;
import com.exemplo.tarefas.repository.UsuarioRepository;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
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
    
 // PUT - atualizar usuário inteiro
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Long id, 
                                                    @Valid @RequestBody Usuario usuarioAtualizado) {
        return usuarioRepository.findById(id)
                .map(usuario -> {
                    usuario.setNome(usuarioAtualizado.getNome());
                    usuario.setEmail(usuarioAtualizado.getEmail());
                    usuario.setSenha(usuarioAtualizado.getSenha());
                    usuario.setTelefone(usuarioAtualizado.getTelefone());
                    usuario.setAtivo(usuarioAtualizado.isAtivo());
                    Usuario salvo = usuarioRepository.save(usuario);
                    return ResponseEntity.ok(salvo);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // PUT - atualizar apenas o campo "ativo"
    @PutMapping("/{id}/ativo")
    public ResponseEntity<Usuario> atualizarStatusAtivo(@PathVariable Long id, 
                                                        @RequestBody boolean ativo) {
        return usuarioRepository.findById(id)
                .map(usuario -> {
                    usuario.setAtivo(ativo);
                    Usuario salvo = usuarioRepository.save(usuario);
                    return ResponseEntity.ok(salvo);
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
