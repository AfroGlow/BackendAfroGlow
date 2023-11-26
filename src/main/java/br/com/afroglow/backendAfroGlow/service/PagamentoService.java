package br.com.afroglow.backendAfroGlow.Service;


// import java.util.List;

import org.springframework.stereotype.Service;

import br.com.afroglow.backendAfroGlow.Models.Pagamento;
@Service
public class PagamentoService {
    public Pagamento buscaPagamento(Integer pagamentoId){
        Pagamento pagamento = new Pagamento(); // Criando um objeto 
        pagamento.idPagamento = 2;
        pagamento.idUsuario = 3;
        pagamento.status = "Rato de esgoto";
        return pagamento;
    }

   /* public List<Pagamento>buscaPagamentos(){
        return List<Pagamento>();
    }*/ 

    
}
