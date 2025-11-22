package br.com.fiap.dto;

public class FeedbackCheckOutDTO {
    private Long idRegistro;
    private boolean nivelCritico;
    private String mensagem;

    public FeedbackCheckOutDTO() {}

    public FeedbackCheckOutDTO(Long idRegistro, boolean nivelCritico, String mensagem) {
        this.idRegistro = idRegistro;
        this.nivelCritico = nivelCritico;
        this.mensagem = mensagem;
    }

    // Getters e Setters obrigatórios para o JSON funcionar
    public Long getIdRegistro() { return idRegistro; }
    public void setIdRegistro(Long idRegistro) { this.idRegistro = idRegistro; }
    public boolean isNivelCritico() { return nivelCritico; }
    public void setNivelCritico(boolean nivelCritico) { this.nivelCritico = nivelCritico; }
    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }
}