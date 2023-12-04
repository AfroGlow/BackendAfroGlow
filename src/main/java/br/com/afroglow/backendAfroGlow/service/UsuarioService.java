package br.com.afroglow.backendAfroGlow.Service;

// import java.sql.Date;
import java.util.Optional;
import java.util.List;
import org.springframework.stereotype.Service;
import br.com.afroglow.backendAfroGlow.Models.Usuario;
import br.com.afroglow.backendAfroGlow.Repository.UsuarioRepository;


@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;


    //Construtor da classe
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }
    public Optional<Usuario> buscarUsuario(Integer usuarioId){
        Optional<Usuario> usuario = usuarioRepository.findById(usuarioId);

        return usuario;
    }

    public List<Usuario> retornarListaDeUsuarios() {
        return usuarioRepository.findAll();
}

    public void adicionarUsuario(Usuario usuario){
        usuarioRepository.save(usuario);
    }

    public void deletarUsuario(Integer usuarioId){
        usuarioRepository.deleteById(usuarioId);
    }

    public void atualizarUsuario(Integer usuarioId){
        usuarioRepository.save(usuarioId);
    }

    // public void adicionarCrianca(Integer criancaId){
    //     criancaRepository.save(criancaId);
    // }



    public void escolherUsuario(Integer tipoDeUsuarioId, Integer usuarioId){
        Optional<Usuario> usuarioObjeto = buscarUsuario(usuarioId);
        if(usuarioObjeto.isPresent()) {
            usuarioObjeto.get().idTipoDeUsuario = tipoDeUsuarioId;
            Usuario usuarioAtualizado = new Usuario();
            // usuarioAtualizado.idUsuario = usuarioObjeto.get().idUsuario;
            usuarioAtualizado = usuarioObjeto.stream().findFirst().orElse(null);
            usuarioRepository.save(usuarioAtualizado);
        } 
}
}