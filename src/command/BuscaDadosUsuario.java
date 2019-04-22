package command;

import bean.Usuario;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BuscaDadosUsuario implements Command {

    private UsuarioImpl usuarioImpl = new UsuarioImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        Usuario usuario = usuarioImpl.getUsuario(Integer.parseInt(request.getParameter("id")));
        request.getSession().setAttribute("id", usuario.getId());
        request.getSession().setAttribute("nome", usuario.getNome());
        request.getSession().setAttribute("email", usuario.getEmail());
        request.getSession().setAttribute("senha", usuario.getSenha());
        request.getSession().setAttribute("sexo", usuario.getSexo());
        request.getSession().setAttribute("idade", usuario.getIdade());
        request.getSession().setAttribute("cpf", usuario.getCpf());
        request.getSession().setAttribute("isAdmin", usuario.getIsAdmin());
        request.getSession().setAttribute("funcao", usuario.getFuncao());
    }
}
