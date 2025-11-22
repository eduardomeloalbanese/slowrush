package br.com.fiap.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "TB_SLOWRUSH_ALERTA_PROATIVO")
public class AlertaProativo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "alerta_seq")
    @SequenceGenerator(name = "alerta_seq", sequenceName = "SQ_T_ALERTA_PROATIVO", allocationSize = 1)
    private Long id;

    private String titulo;
    private String mensagem;
    private LocalDateTime dataHoraAlerta;
    private boolean confirmado;

    public AlertaProativo() {}

    public AlertaProativo(String titulo, String mensagem, LocalDateTime dataHoraAlerta, boolean confirmado) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.dataHoraAlerta = dataHoraAlerta;
        this.confirmado = confirmado;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDateTime getDataHoraAlerta() {
        return dataHoraAlerta;
    }

    public void setDataHoraAlerta(LocalDateTime dataHoraAlerta) {
        this.dataHoraAlerta = dataHoraAlerta;
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }
}