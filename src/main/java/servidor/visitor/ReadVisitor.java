package servidor.visitor;

import com.google.gson.GsonBuilder;
import servidor.banco.BancoDev;
import servidor.banco.BancoEmpresa;
import servidor.banco.BancoGerente;
import servidor.entities.Dev;
import servidor.entities.Empresa;
import servidor.entities.Gerente;

public class ReadVisitor<T> implements Visitor {
    T elemento;

    @Override
    public void visitGerente(Gerente gerente) {
        elemento = (T) BancoGerente.getInstance().getByCPF(gerente.getCpf());
        var gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String mensagem = "Não foi encontrado nenhum gerente com esse cpf";
        if (elemento != null) {
            mensagem = gson.toJson(elemento);
        }
        sendMessageToServer(mensagem);
    }

    @Override
    public void visitDev(Dev dev) {
        elemento = (T) BancoDev.getInstance().getByCPF(dev.getCpf());
        var gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String mensagem = "Não foi encontrado nenhum DEV com esse cpf";
        if (elemento != null) {
            mensagem = gson.toJson(elemento);
        }
        sendMessageToServer(mensagem);
    }

    @Override
    public void visitEmpresa(Empresa empresa) {
        elemento = (T) BancoEmpresa.getInstance().getByNome(empresa.getNome());
        var gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String mensagem = "Não foi encontrado nenhuma empresa com esse nome";
        if (elemento != null) {
            mensagem = gson.toJson(elemento);
        }
        sendMessageToServer(mensagem);
    }

    public T getElemento() {
        return elemento;
    }
}
