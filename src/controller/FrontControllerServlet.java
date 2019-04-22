package controller;

import command.Invoker;
import util.Util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class FrontControllerServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String command = request.getParameter("command");

        if (command == null) {
            request.setAttribute("error", "Você deve selecionar uma ação.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }

        Invoker invoker = new Invoker(request, response);

        request.removeAttribute("error");
        request.removeAttribute("success");
        HttpSession session = request.getSession();

        if (!(command.equals("cadastro") || command.equals("login") || command.equals("cadastrar"))) {
            if (!Util.isAutenticado(session)) {
                request.setAttribute("error", "Você deve se autenticar para acessar o sistema.");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                return;
            }
        }

        switch (command){

            case "cadastro":
                request.getRequestDispatcher("views/cadastro.jsp").forward(request, response);
                break;

            case "login":

                if (Util.isEmpty(request, 1)) {
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    return;
                }

                try {
                    invoker.invoke("login");
                    invoker.invoke("listaUsuarios");
                    request.getRequestDispatcher("views/principal.jsp").forward(request, response);

                } catch (Exception e) {
                    request.getSession().invalidate();
                    request.setAttribute("error", "Ocorreu um erro ao fazer login.\n" + e.getLocalizedMessage());
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
                break;

            case "logout":
                session.invalidate();
                request.setAttribute("success", "Deslogado do sistema com sucesso!");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;

            case "altera":
                try {
                    invoker.invoke("altera");
                    request.getRequestDispatcher("views/atualiza.jsp").forward(request, response);

                } catch (Exception e) {
                    invoker.invoke("listaUsuarios");
                    request.setAttribute("error", "Não foi possível buscar os dados do usuário.\n" + e.getLocalizedMessage());
                    request.getRequestDispatcher("views/principal.jsp").forward(request, response);
                }
                break;

            case "principal":
                try {
                    invoker.invoke("listaUsuarios");
                    request.getRequestDispatcher("views/principal.jsp").forward(request, response);
                } catch (Exception e) {
                    request.setAttribute("error", "Ocorreu um erro ao acessar o sistema.\n" + e.getLocalizedMessage());
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
                break;

            case "cadastrar":

                if (Util.isEmpty(request, 0)) {
                    request.getRequestDispatcher("views/cadastro.jsp").forward(request, response);
                    return;
                }

                try {
                    invoker.invoke("cadastrar");
                    if (!Util.isAutenticado(session)) {
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    } else {
                        invoker.invoke("listaUsuarios");
                        request.getRequestDispatcher("views/principal.jsp").forward(request, response);
                    }

                } catch (Exception e) {
                    request.setAttribute("error", "Ocorreu um erro ao cadastrar o Usuário.\n" + e.getLocalizedMessage());
                    request.getRequestDispatcher("views/cadastro.jsp").forward(request, response);
                    return;
                }
                break;

            case "editar":
                if (Util.isEmpty(request, 0)) {
                    String id = request.getParameter("id");
                    request.getRequestDispatcher("views/atualiza.jsp?command=editar&id=" + id).forward(request, response);
                    return;
                }
                try {
                    invoker.invoke("editar");
                    invoker.invoke("listaUsuarios");
                    request.getRequestDispatcher("views/principal.jsp").forward(request, response);
                } catch (Exception e) {
                    invoker.invoke("listaUsuarios");
                    request.setAttribute("error", "Ocorreu um erro ao editar o usuário.\n" + e.getLocalizedMessage());
                    request.getRequestDispatcher("views/principal.jsp").forward(request, response);
                    return;
                }
                break;

            case "excluir":
                try {
                    invoker.invoke("excluir");
                    invoker.invoke("listaUsuarios");
                    request.getRequestDispatcher("views/principal.jsp").forward(request, response);
                } catch (Exception e) {
                    invoker.invoke("listaUsuarios");
                    request.setAttribute("error", "Ocorreu um erro ao excluir o usuário.\n" + e.getLocalizedMessage());
                    request.getRequestDispatcher("views/principal.jsp").forward(request, response);
                    return;
                }
                break;
        }
    }
}
