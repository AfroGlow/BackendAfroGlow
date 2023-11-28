package br.com.afroglow.backendAfroGlow.Service;

import java.sql.Date;

import br.com.afroglow.backendAfroGlow.Models.Usuario;

public class UsuarioService {
    public Usuario buscaUsuario(Integer usuarioId){
        Usuario usuario = new Usuario();
        usuario.idUsuario = 7;
        usuario.idDefinicaoDeCabelo = 7;
        usuario.idTipoDeUsuario = 7;
        usuario.nomeCompleto = "Rato";
        usuario.nomeSocial = "Ricardo";
        usuario.dataDeNascimento = new Date(20030120);
        usuario.genero = "não-binari";
        usuario.email = "<ricardo.sao@hotmail.com>";
        usuario.senha = "<picoloVerde>";
        usuario.telefone = "554888888";
        usuario.cpf = "50651635824";
        usuario.status = "não aceito na sociedade";
        return usuario;
    }

//     public List<Usuario>(buscarUsuarios usuarios) {
    
// }

    public void adicionarUsuario(Usuario usuario){
        
    }

    public void deletarUsuario(Integer usuarioId){

    }

    public void atualizarUsuario(Usuario usuarioId){

    }

    public void adicionarCrianca(Integer criancaId){

    }

    public void adicionarPlano(Integer planoId){

    }

    public void escolherUsuario(Integer TipoDeUsuarioId){
}

}