package br.com.afroglow.backendAfroGlow.Controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.afroglow.backendAfroGlow.Models.Pagamento;
import br.com.afroglow.backendAfroGlow.service.PagamentoService;

@RestController
@RequestMapping(value = "pagamento")
public class PagamentoController {

    PagamentoService pagamentoService = new PagamentoService();

    // Metodo para retornar pagamento buscando pelo id 
    @GetMapping(value = "/{pagamentoId}") // Rota e tipo do endPoint
    public Pagamento getPagamento(@PathVariable Integer pagamentoId){
        

        return pagamentoService.buscaPagamento(pagamentoId);
    }   

    @GetMapping 
    public Pagamento getTeste(){
        Pagamento teste = new Pagamento();
        return teste; 
    }

}

