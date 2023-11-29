package br.com.afroglow.backendAfroGlow.DTO;

public class PedidoBoxRequestDTO {

    private Long idUsuario;
    private Long idBox;
    private Long idPagamento;

    // Getters and setters

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getIdBox() {
        return idBox;
    }

    public void setIdBox(Long idBox) {
        this.idBox = idBox;
    }

    public Long getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(Long idPagamento) {
        this.idPagamento = idPagamento;
    }
}
