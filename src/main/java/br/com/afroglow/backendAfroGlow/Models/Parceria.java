package br.com.afroglow.backendAfroGlow.Models;



import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Entity
public class Parceria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(nullable = false)
    public Long idParceiro; //

    @NotBlank
    public String nomeColab; //

    @NotNull
    public Long idEndereco;

    @NotNull
    @Size(min = 9, max = 20)
    public Long telefone;

    @NotNull
    @Size(min = 14, max = 18)
    public Long cnpj;

    @NotNull
    public Integer status;

    @NotBlank
    public String marcaDoProduto;

    @NotBlank
    public String tipoDeParceria;

    @NotBlank
    public String validadeDeContrato;

   

}
