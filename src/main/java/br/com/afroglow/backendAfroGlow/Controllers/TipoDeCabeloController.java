package br.com.afroglow.backendAfroGlow.Controllers;

import java.util.ArrayList;
import java.util.List;

import br.com.afroglow.backendAfroGlow.Models.TipoDeCabelo;

public class TipoDeCabeloController {
    private List<TipoDeCabelo> listaDeTiposDeCabelo;

    public TipoDeCabeloController() {
        this.listaDeTiposDeCabelo = new ArrayList<>();
    }

    
    public void salvarTipoDeCabelo(TipoDeCabelo tipoDeCabelo) {
        listaDeTiposDeCabelo.add(tipoDeCabelo);
     
    }

 
    public List<TipoDeCabelo> buscarTodosTiposDeCabelo() {
        return listaDeTiposDeCabelo;
    }

    
    public TipoDeCabelo buscarTipoDeCabeloPorId(int idTipoDeCabelo) {
        for (TipoDeCabelo tipoDeCabelo : listaDeTiposDeCabelo) {
            if (tipoDeCabelo.getIdTipoDeCabelo() == idTipoDeCabelo) {
                return tipoDeCabelo;
            }
        }
        return null;
    }

   

    
    public void atualizarCurvaturaDoCabelo(int idTipoDeCabelo, String novaCurvatura) {
        for (TipoDeCabelo tipoDeCabelo : listaDeTiposDeCabelo) {
            if (tipoDeCabelo.getIdTipoDeCabelo() == idTipoDeCabelo) {
                tipoDeCabelo.setCurvaturaDoCabelo(novaCurvatura);
             
                return;
            }
        }
      
    }

    
    public void deletarTipoDeCabelo(int idTipoDeCabelo) {
        listaDeTiposDeCabelo.removeIf(tipoDeCabelo -> tipoDeCabelo.getIdTipoDeCabelo() == idTipoDeCabelo);
      
    }
}