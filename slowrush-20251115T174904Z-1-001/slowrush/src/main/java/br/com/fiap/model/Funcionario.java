package br.com.fiap.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_SLOWRUSH_FUNCIONARIO")
public class Funcionario {

    @Id
    private String email;

    private String nome;
    private LocalDateTime ultimoAcesso;
    private int totalAcessos;
    private boolean ativo;
    private int tentativasFalhas;


    public Funcionario() {}

    public Funcionario(String nome, String email, LocalDateTime ultimoAcesso, int totalAcessos, boolean ativo, int tentativasFalhas) {
        this.nome = nome;
        this.email = email;
        this.ultimoAcesso = ultimoAcesso;
        this.totalAcessos = totalAcessos;
        this.ativo = ativo;
        this.tentativasFalhas = tentativasFalhas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getUltimoAcesso() {
        return ultimoAcesso;
    }

    public void setUltimoAcesso(LocalDateTime ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
    }

    public int getTotalAcessos() {
        return totalAcessos;
    }

    public void setTotalAcessos(int totalAcessos) {
        this.totalAcessos = totalAcessos;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public int getTentativasFalhas() {
        return tentativasFalhas;
    }

    public void setTentativasFalhas(int tentativasFalhas) {
        this.tentativasFalhas = tentativasFalhas;
    }
}