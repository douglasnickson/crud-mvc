package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExcluirUsuarioCommand implements Command {

    private UsuarioImpl usuarioImpl = new UsuarioImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {
        usuarioImpl.deletar(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("success", "Usuário deletado com sucesso!");
    }
}
