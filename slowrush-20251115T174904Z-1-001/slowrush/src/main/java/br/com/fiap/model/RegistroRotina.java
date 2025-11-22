package br.com.fiap.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "T_SLOWRUSH_REGISTRO") // Nome da tabela no banco
public class RegistroRotina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String funcionario;

    // Recebe como String do front ("9.5" ou "8")
    private String horasTrabalhadas;

    // Recebe "Alta", "Média", etc.
    private String intensidadeReunioes;

    // Recebe "stress", "tired", "ok", "rad"
    private String sentimento;

    @Column(length = 500)
    private String comentario;

    private String data; // Guardando como String para simplificar a formatação vinda do front

    // Construtor vazio obrigatório
    public RegistroRotina() {}

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getFuncionario() { return funcionario; }
    public void setFuncionario(String funcionario) { this.funcionario = funcionario; }
    public String getHorasTrabalhadas() { return horasTrabalhadas; }
    public void setHorasTrabalhadas(String horasTrabalhadas) { this.horasTrabalhadas = horasTrabalhadas; }
    public String getIntensidadeReunioes() { return intensidadeReunioes; }
    public void setIntensidadeReunioes(String intensidadeReunioes) { this.intensidadeReunioes = intensidadeReunioes; }
    public String getSentimento() { return sentimento; }
    public void setSentimento(String sentimento) { this.sentimento = sentimento; }
    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }
    public String getData() { return data; }
    public void setData(String data) { this.data = data; }

    @Override
    public String toString() {
        return "RegistroRotina{funcionario='" + funcionario + "', sentimento='" + sentimento + "'}";
    }
}