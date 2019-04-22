package dao;

import bean.Usuario;

import java.util.List;

public interface UsuarioDao {

    void inserir (Usuario usuario);
    void alterar (Usuario usuario);
    void deletar (int id);
    Usuario getUsuario (int id);
    List<Usuario> getUsuarioByEmailSenha(String email, String senha);

}
