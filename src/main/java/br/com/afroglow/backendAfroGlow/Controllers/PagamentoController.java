package br.com.afroglow.backendAfroGlow.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.afroglow.backendAfroGlow.Models.Pagamento;
import br.com.afroglow.backendAfroGlow.Service.PagamentoService;
import java.util.Optional;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {
 
    @Autowired
    private final PagamentoService pagamentoService;

   
    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    
    @GetMapping(value = "/{pagamentoId}")
    public Optional<Pagamento> getPagamento(@PathVariable Integer pagamentoId) {

        return pagamentoService.buscaPagamento(pagamentoId);
    }
}
