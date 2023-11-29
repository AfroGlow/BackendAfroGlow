package br.com.afroglow.backendAfroGlow.Service;


// import java.util.List;
import br.com.afroglow.backendAfroGlow.Repository.PagamentoRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import br.com.afroglow.backendAfroGlow.Models.Pagamento;

@Service
public class PagamentoService {
    private final PagamentoRepository pagamentoRepository;

    //Construtor da classe
    public PagamentoService(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }
    public Optional<Pagamento> buscaPagamento(Integer pagamentoId){
        Optional<Pagamento> pagamento = pagamentoRepository.findById(pagamentoId); // Criando um objeto 
        // pagamento.idPagamento = 2;
        // pagamento.idUsuario = 3;
        // pagamento.status = "Rato de esgoto";
        return pagamento;
    }

   public List<Pagamento> buscaPagamentos(){
        return pagamentoRepository.findAll();
    

   }
}
