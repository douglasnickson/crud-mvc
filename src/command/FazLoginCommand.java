package command;

import bean.Usuario;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class FazLoginCommand implements Command {

    private UsuarioImpl usuarioImpl = new UsuarioImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        List<Usuario> listaUsuario;

        listaUsuario = usuarioImpl.getUsuarioByEmailSenha(email, senha);
        if (listaUsuario.size() > 0) {

            request.getSession().setAttribute("autenticado", true);
            request.getSession().setAttribute("nomeAutenticado", listaUsuario.get(0).getNome());
            request.setAttribute("success", "Login efetuado com sucesso!");
        }
    }
}
