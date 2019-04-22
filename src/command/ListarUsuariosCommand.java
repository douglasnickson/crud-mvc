package command;

import bean.Usuario;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ListarUsuariosCommand implements Command{

    private UsuarioImpl usuarioImpl = new UsuarioImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        List<Usuario> listaTodosUsuarios;
        listaTodosUsuarios = usuarioImpl.getListaUsuarios();
        request.setAttribute("usuarios", listaTodosUsuarios);
    }
}
