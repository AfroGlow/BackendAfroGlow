package br.com.afroglow.backendAfroGlow.Service;

import br.com.afroglow.backendAfroGlow.Models.Usuario;
import br.com.afroglow.backendAfroGlow.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Optional<Usuario> buscarUsuarioPorEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public List<Usuario> retornarListaDeUsuarios() {
        return usuarioRepository.findAll();
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public void deletarUsuario(Long usuarioId) {
        usuarioRepository.deleteById(usuarioId);
    }

    public void atualizarUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public void escolherUsuario(Integer tipoDeUsuarioId, Long usuarioId) {
        Optional<Usuario> usuarioObjeto = usuarioRepository.findById(usuarioId);
        usuarioObjeto.ifPresent(usuario -> {
            usuario.setIdTipoDeUsuario(tipoDeUsuarioId);
            usuarioRepository.save(usuario);
        });
    }

    // Este método não faz nada, você pode removê-lo se não for utilizado
    public Optional<Usuario> buscarUsuario(Long usuarioId) {
        return usuarioRepository.findById(usuarioId);
    }
}
