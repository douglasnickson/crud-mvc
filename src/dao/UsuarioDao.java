package dao;

import bean.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class UsuarioDao {

    private Connection conn;
    private PreparedStatement preparedStatement;
    private Statement statement;
    private ResultSet resultSet;
    private ArrayList<Usuario> listaUsuarios;

    public UsuarioDao() {
        conn = new ConnectionDao().getConnection();
    }

    public void inserir (Usuario usuario) {
        String sql = "INSERT INTO TBL_USUARIO (nome, email, senha) VALUES (?, ?, ?)";
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setString(2, usuario.getEmail());
            preparedStatement.setString(3, usuario.getSenha());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (Exception e) {
            throw new RuntimeException("Erro 2: " + e);
        }
    }

    public void alterar (Usuario usuario) {
        String sql = "UPDATE TBL_USUARIO SET nome = ?, email = ?, senha = ? WHERE ID = ?";
        try {
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setString(2, usuario.getEmail());
            preparedStatement.setString(3, usuario.getSenha());
            preparedStatement.setInt(4, usuario.getId());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (Exception e) {
            throw new RuntimeException("Erro 3: " + e);
        }
    }

    public void deletar (int id) {
        String sql = "DELETE FROM TBL_USUARIO WHERE ID = " + id;
        try {
            statement = conn.createStatement();
            statement.execute(sql);
            statement.close();
        } catch (Exception e) {
            throw new RuntimeException("Erro 4: " + e);
        }
    }

    public ArrayList<Usuario> getListaUsuarios () {
        String sql = "SELECT * FROM TBL_USUARIO";
        listaUsuarios = new ArrayList<>();
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(resultSet.getInt("ID"));
                usuario.setNome(resultSet.getString("NOME"));
                usuario.setEmail(resultSet.getString("EMAIL"));
                usuario.setSenha(resultSet.getString("SENHA"));
                listaUsuarios.add(usuario);
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro 5: " + e);
        }
        return listaUsuarios;
    }

    public Usuario getUsuario (int id) {
        String sql = "SELECT * FROM TBL_USUARIO WHERE ID =" + id;
        listaUsuarios = new ArrayList<>();
        Usuario usuario = new Usuario();
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                usuario.setId(resultSet.getInt("ID"));
                usuario.setNome(resultSet.getString("NOME"));
                usuario.setEmail(resultSet.getString("EMAIL"));
                usuario.setSenha(resultSet.getString("SENHA"));
                listaUsuarios.add(usuario);
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro 6: " + e);
        }
        return usuario;
    }
}
