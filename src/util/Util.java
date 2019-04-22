package util;

import bean.Usuario;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Util {
    public static boolean isEmpty(HttpServletRequest request, int flag) {

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String nome = request.getParameter("nome");

        if (flag == 0) {
            if (nome.equals("") || email.equals("") || senha.equals("")) {
                request.setAttribute("error", "Você deve preencher todos os dados.");
                return true;
            }
        } else if (flag == 1) {
            if (email.equals("") || senha.equals("")) {
                request.setAttribute("error", "Você deve informar o email e senha.");
                return true;
            }
        }
        return false;
    }

    public static boolean isAutenticado (HttpSession session) {

        return session.getAttribute("autenticado") != null && !session.getAttribute("autenticado").equals("");
    }

    public static void setUsuarioObjeto(HttpServletRequest request, Usuario usuario) {
        usuario.setNome(request.getParameter("nome"));
        usuario.setEmail(request.getParameter("email"));
        usuario.setSenha(request.getParameter("senha"));
        usuario.setSexo(request.getParameter("sexo"));
        usuario.setIdade(Integer.parseInt(request.getParameter("idade")));
        usuario.setCpf(request.getParameter("cpf"));
        usuario.setIsAdmin(request.getParameter("isAdmin"));
        usuario.setFuncao(request.getParameter("funcao"));
    }
}
