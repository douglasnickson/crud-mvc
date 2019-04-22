package command;

import bean.Usuario;
import dao.ConnectionDao;
import dao.UsuarioDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioImpl implements UsuarioDao {

    private Connection conn;
    private PreparedStatement preparedStatement;
    private Statement statement;
    private ResultSet resultSet;

    UsuarioImpl() {
        conn = new ConnectionDao().getConnection();
    }

    public void inserir (Usuario usuario) {
        String sql = "INSERT INTO TBL_USUARIO (nome, email, senha, sexo, idade, cpf, isAdmin, funcao) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            setUsuarioInfo(usuario, sql);
            preparedStatement.execute();
            preparedStatement.close();
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e);
        }
    }

    public void alterar (Usuario usuario) {
        String sql = "UPDATE TBL_USUARIO SET nome = ?, email = ?, senha = ?, sexo = ?, idade = ?, cpf = ?, isAdmin = ?, funcao = ? WHERE ID = ?";
        try {
            setUsuarioInfo(usuario, sql);
            preparedStatement.setInt(9, usuario.getId());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e);
        }
    }

    public void deletar (int id) {
        String sql = "DELETE FROM TBL_USUARIO WHERE ID = " + id;
        try {
            statement = conn.createStatement();
            statement.execute(sql);
            statement.close();
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e);
        }
    }

    public ArrayList<Usuario> getListaUsuarios () {
        String sql = "SELECT * FROM TBL_USUARIO";
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Usuario usuario = new Usuario();
                getUsuarioInfo(usuario, listaUsuarios);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e);
        }
        return listaUsuarios;
    }



    public Usuario getUsuario (int id) {
        String sql = "SELECT * FROM TBL_USUARIO WHERE ID =" + id;
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        Usuario usuario = new Usuario();
        try {
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                getUsuarioInfo(usuario, listaUsuarios);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e);
        }
        return usuario;
    }

    public List<Usuario> getUsuarioByEmailSenha(String email, String senha) {
        String sql = "SELECT * FROM TBL_USUARIO WHERE email = ? AND SENHA = ?";
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        Usuario usuario = new Usuario();
        try {

            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, senha);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                getUsuarioInfo(usuario, listaUsuarios);
            }

            if (listaUsuarios.size() <= 0) {
                throw new RuntimeException("Nenhum usuário encontrado na base de dados.");
            }

        } catch (Exception e) {
            throw new RuntimeException("Error: " + e);
        }
        return listaUsuarios;
    }

    private void setUsuarioInfo(Usuario usuario, String sql) throws SQLException {
        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1, usuario.getNome());
        preparedStatement.setString(2, usuario.getEmail());
        preparedStatement.setString(3, usuario.getSenha());
        preparedStatement.setString(4, usuario.getSexo());
        preparedStatement.setInt(5, usuario.getIdade());
        preparedStatement.setString(6, usuario.getCpf());
        preparedStatement.setString(7, usuario.getIsAdmin());
        preparedStatement.setString(8, usuario.getFuncao());
    }

    private void getUsuarioInfo(Usuario usuario, ArrayList<Usuario> listaUsuarios) throws SQLException {
        usuario.setId(resultSet.getInt("ID"));
        usuario.setNome(resultSet.getString("NOME"));
        usuario.setEmail(resultSet.getString("EMAIL"));
        usuario.setSenha(resultSet.getString("SENHA"));
        usuario.setSexo(resultSet.getString("SEXO"));
        usuario.setIdade(resultSet.getInt("IDADE"));
        usuario.setCpf(resultSet.getString("CPF"));
        usuario.setIsAdmin(resultSet.getString("ISADMIN"));
        usuario.setFuncao(resultSet.getString("FUNCAO"));
        listaUsuarios.add(usuario);
    }

}
