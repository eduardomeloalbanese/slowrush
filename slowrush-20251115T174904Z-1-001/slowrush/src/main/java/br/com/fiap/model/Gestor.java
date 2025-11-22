package br.com.fiap.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_SLOWRUSH_GESTOR")
public class Gestor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gestor_seq")
    @SequenceGenerator(name = "gestor_seq", sequenceName = "SQ_T_GESTOR", allocationSize = 1)
    private Long id;

    private String nome;
    private String sexo;
    private String telefone;

    public Gestor () {}

    public Gestor (String nome, String sexo, String telefone) {
        this.nome = nome;
        this.sexo = sexo;
        this.telefone = telefone;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}