package servidor.visitor;

import servidor.banco.BancoDev;
import servidor.banco.BancoEmpresa;
import servidor.banco.BancoGerente;
import servidor.entities.Dev;
import servidor.entities.Empresa;
import servidor.entities.Gerente;

public class DeleteVisitor implements Visitor{
    @Override
    public void visitGerente(Gerente gerente) {
        var gerenteNoBanco = BancoGerente.getInstance().getByCPF(gerente.getCpf());
        if (gerenteNoBanco == null) {
            String mensagem = "Gerente não existe!";
            sendMessageToServer(mensagem);
        } else {
            BancoGerente.getInstance().remove(gerenteNoBanco);
            String mensagem = "Gerente de cpf " + gerente.getCpf() + " removido!";
            sendMessageToServer(mensagem);
        }
    }

    @Override
    public void visitDev(Dev dev) {
        var devNoBanco = BancoDev.getInstance().getByCPF(dev.getCpf());
        if (devNoBanco == null) {
            String mensagem = "Dev não existe!";
            sendMessageToServer(mensagem);
        } else {
            BancoDev.getInstance().remove(devNoBanco);
            String mensagem = "Dev de cpf " + dev.getCpf() + " removido!";
            sendMessageToServer(mensagem);
        }
    }

    @Override
    public void visitEmpresa(Empresa empresa) {
        var empresaNoBanco = BancoEmpresa.getInstance().getByNome(empresa.getNome());
        if (empresaNoBanco == null) {
            String mensagem = "Empresa não existe!";
            sendMessageToServer(mensagem);
        } else {
            BancoEmpresa.getInstance().remove(empresaNoBanco);
            String mensagem = "Empresa " + empresa.getNome() + " removida!";
            sendMessageToServer(mensagem);
        }
    }

}