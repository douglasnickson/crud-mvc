package controller;

import bean.Usuario;
import dao.UsuarioDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class UsuarioServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String flag = request.getParameter("flag");

        if (flag == null) {
            request.setAttribute("Erro 7: ", "Os dados informados estão incorretos.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }

        if (request.getParameter("nome") == null || request.getParameter("email") == null || request.getParameter("senha") == null) {
            request.setAttribute("Erro 8: ", "Você deve preencher todos os dados");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }

        Usuario usuario = new Usuario();
        UsuarioDao usuarioDao = new UsuarioDao();

        switch (flag){
            case "cadastro":
                request.getRequestDispatcher("views/cadastro.jsp").forward(request, response);
                break;
            case "alteracao":
                request.getRequestDispatcher("views/atualizacao.jsp").forward(request, response);
                break;

            case "cadastrar":


        }

    }
}
