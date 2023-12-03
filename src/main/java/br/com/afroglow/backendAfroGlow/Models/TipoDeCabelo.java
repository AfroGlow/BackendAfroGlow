package br.com.afroglow.backendAfroGlow.Models;

public class TipoDeCabelo {
    private int idTipoDeCabelo;
    private String tipoDeCabelo;
    private String curvaturaDoCabelo;
    private String danoDoCabelo;
    private boolean transicaoCapilar;
    private int idDefinicaoDoCabelo;
    private int idUsuario;

   
    public TipoDeCabelo(int idTipoDeCabelo, String tipoDeCabelo, String curvaturaDoCabelo,
                        String danoDoCabelo, boolean transicaoCapilar, int idDefinicaoDoCabelo,
                        int idUsuario) {
        this.idTipoDeCabelo = idTipoDeCabelo;
        this.tipoDeCabelo = tipoDeCabelo;
        this.curvaturaDoCabelo = curvaturaDoCabelo;
        this.danoDoCabelo = danoDoCabelo;
        this.transicaoCapilar = transicaoCapilar;
        this.idDefinicaoDoCabelo = idDefinicaoDoCabelo;
        this.idUsuario = idUsuario;
    }

    public int getIdTipoDeCabelo() {
        return 0;
    }

    public void setCurvaturaDoCabelo(String novaCurvatura) {
    }


}
