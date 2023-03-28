package servidor.visitor;

import com.google.gson.GsonBuilder;
import servidor.banco.BancoDev;
import servidor.banco.BancoEmpresa;
import servidor.banco.BancoGerente;
import servidor.entities.Dev;
import servidor.entities.Empresa;
import servidor.entities.Gerente;

public class ListarVisitor implements Visitor {
    @Override
    public void visitGerente(Gerente gerente) {
        var elemento = BancoGerente.getInstance().getArrayListEntidade();
        var gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String mensagem = "Não foi encontrado nenhum gerente";
        if (elemento != null && !elemento.isEmpty()) {
            mensagem = gson.toJson(elemento);
        }
        sendMessageToServer(mensagem);
    }

    @Override
    public void visitDev(Dev dev) {
        var elemento = BancoDev.getInstance().getArrayListEntidade();
        var gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String mensagem = "Não foi encontrado nenhum dev";
        if (elemento != null && !elemento.isEmpty()) {
            mensagem = gson.toJson(elemento);
        }
        sendMessageToServer(mensagem);
    }

    @Override
    public void visitEmpresa(Empresa empresa) {
        var elemento = BancoEmpresa.getInstance().getArrayListEntidade();
        var gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String mensagem = "Não foi encontrado nenhuma empresa";
        if (elemento != null && !elemento.isEmpty()) {
            mensagem = gson.toJson(elemento);
        }
        sendMessageToServer(mensagem);
    }
}
