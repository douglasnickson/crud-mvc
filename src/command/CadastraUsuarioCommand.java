package command;

import bean.Usuario;
import util.Util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastraUsuarioCommand implements Command {

    private UsuarioImpl usuarioImpl = new UsuarioImpl();
    private Usuario usuario = new Usuario();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        Util.setUsuarioObjeto(request, usuario);
        usuarioImpl.inserir(usuario);
        request.setAttribute("success", "Usuário cadastrado com sucesso!");
    }

}
