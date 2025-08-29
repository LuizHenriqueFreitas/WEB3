package com.exemplo.tarefas.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @NotBlank(message = "O nome não pode ser vazio")
    @Size(max = 100, message = "O nome não pode ter mais que 100 caracteres")
    private String nome;

    @NotBlank(message = "O e-mail não pode ser vazio")
    @Email(message = "Formato de e-mail inválido")
    private String email;

    @NotBlank(message = "A senha não pode ser vazia")
    private String senha;

    private String telefone;

    private boolean ativo;

    // Getters e setters
    public Long getCodigo() { return codigo; }
    public void setCodigo(Long codigo) { this.codigo = codigo; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }

    public boolean isAtivo() { return ativo; }
    public void setAtivo(boolean ativo) { this.ativo = ativo; }
}
