package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class Invoker {

    private static Map<String, Command> comandos = new HashMap<>();
    private HttpServletRequest request;
    private HttpServletResponse response;

    public Invoker (HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    static {
        comandos.put("cadastrar", new CadastraUsuarioCommand());
        comandos.put("editar", new AtualizaUsuarioCommand());
        comandos.put("excluir", new ExcluirUsuarioCommand());
        comandos.put("altera", new BuscaDadosUsuario());
        comandos.put("listaUsuarios", new ListarUsuariosCommand());
        comandos.put("login", new FazLoginCommand());
    }

    public void invoke (String command) {
        comandos.get(command).execute(request, response);
    }
}
