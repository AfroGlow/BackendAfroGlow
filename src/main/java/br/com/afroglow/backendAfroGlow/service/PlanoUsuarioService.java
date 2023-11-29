package br.com.afroglow.backendAfroGlow.Service;

import br.com.afroglow.backendAfroGlow.Repository.PlanoUsuarioRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import br.com.afroglow.backendAfroGlow.Models.PlanoUsuario;

@Service
public class PlanoUsuarioService {

    private final PlanoUsuarioRepository planoUsuarioRepository;

    // Construtor da classe
    public PlanoUsuarioService(PlanoUsuarioRepository planoUsuarioRepository) {
        this.planoUsuarioRepository = planoUsuarioRepository;
    }

        //Criando objeto, passando paramentros para o objeto e salvando o objeto no repositório.
        public void vincularPlanoUsuario(Integer planoId, Integer usuarioId, String statusPagamento){
            PlanoUsuario planoUsuarioObjeto = new PlanoUsuario();
            planoUsuarioObjeto.idUsuario = usuarioId;
            planoUsuarioObjeto.idPlano = planoId;
            planoUsuarioObjeto.statusPagamento = statusPagamento;
            planoUsuarioRepository.save(planoUsuarioObjeto); 
        }

    public Optional<PlanoUsuario> buscaPlanoUsuario(Integer planoUsuarioId) {
        Optional<PlanoUsuario> planoUsuario = planoUsuarioRepository.findById(planoUsuarioId);
        // planoUsuario.idPlanoUsuario = 2;
        // planoUsuario.idUsuario = 8;
        // planoUsuario.idPlanoUsuario = 7;
        // planoUsuario.statusPagamento = "Não mim pagarão";
        return planoUsuario;
    }

    public List<PlanoUsuario> retornarListaPlanoUsuarios() {
        return planoUsuarioRepository.findAll();
    }

    public void adicionarPlanoUsuario(PlanoUsuario planoUsuario) {
        planoUsuarioRepository.save(planoUsuario);
    }

    public void deletarPlanoUsuario(Integer planoUsuarioId) {
        planoUsuarioRepository.deleteById(planoUsuarioId);
    }

    public void atualizarPlanoUsuario(PlanoUsuario planoUsuario) {
        planoUsuarioRepository.save(planoUsuario);
    }

}
