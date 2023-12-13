package br.com.afroglow.backendAfroGlow.Models;



import jakarta.persistence.*;


@Entity
public class Parceria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(nullable = false)
    public Long idParceiro; 

   
    public String nomeColab; 


    public Long idEndereco;


  
    public Long telefone;

   
    public Long cnpj;


    public Integer status;


    public String marcaDoProduto;

    public String tipoDeParceria;


    public String validadeDeContrato;

   

}
