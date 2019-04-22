package command;

import bean.Usuario;
import util.Util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AtualizaUsuarioCommand implements Command {
    private UsuarioImpl usuarioImpl = new UsuarioImpl();
    private Usuario usuario = new Usuario();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        usuario.setId(Integer.parseInt(request.getParameter("id")));
        Util.setUsuarioObjeto(request, usuario);
        usuarioImpl.alterar(usuario);

        request.getSession().removeAttribute("nome");
        request.getSession().removeAttribute("email");
        request.getSession().removeAttribute("senha");
        request.getSession().removeAttribute("sexo");
        request.getSession().removeAttribute("idade");
        request.getSession().removeAttribute("cpf");
        request.getSession().removeAttribute("id");
        request.setAttribute("success", "Usuário editado com sucesso!");
    }
}
