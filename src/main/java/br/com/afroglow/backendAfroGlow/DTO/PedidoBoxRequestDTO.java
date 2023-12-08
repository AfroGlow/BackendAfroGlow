package br.com.afroglow.backendAfroGlow.DTO;

public class PedidoBoxRequestDTO {

    private Integer idUsuario;
    private Integer idBox;
    private Integer idPagamento;

    // Getters and setters

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdBox() {
        return idBox;
    }

    public void setIdBox(Integer idBox) {
        this.idBox = idBox;
    }

    public Integer getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(Integer idPagamento) {
        this.idPagamento = idPagamento;
    }
}
