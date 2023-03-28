package servidor.visitor;

import servidor.api.ConexaoServidor;
import servidor.entities.Dev;
import servidor.entities.Empresa;
import servidor.entities.Gerente;

import java.io.IOException;

public interface Visitor {
    void visitGerente(Gerente gerente);
    void visitDev(Dev dev);
    void visitEmpresa(Empresa empresa);

    default void sendMessageToServer(String mensagem) {
        System.out.println(mensagem);
        try {
            ConexaoServidor.getInstance().sendMessage(mensagem);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
