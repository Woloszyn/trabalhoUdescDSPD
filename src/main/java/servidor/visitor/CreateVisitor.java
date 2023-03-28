package servidor.visitor;

import servidor.banco.BancoDev;
import servidor.banco.BancoEmpresa;
import servidor.banco.BancoGerente;
import servidor.entities.Dev;
import servidor.entities.Empresa;
import servidor.entities.Gerente;

public class CreateVisitor implements Visitor{

    @Override
    public void visitGerente(Gerente gerente) {
        var gerenteNoBanco = BancoGerente.getInstance().getByCPF(gerente.getCpf());
        if (gerenteNoBanco == null) {
            var banco = BancoGerente.getInstance();
            banco.add(gerente);
            String mensagemSucesso = "Gerente " + gerente.getNome() + " adicionado com sucesso";
            sendMessageToServer(mensagemSucesso);
        } else {
            sendMessageToServer("Já existe gerente com esse cpf");
        }
    }

    @Override
    public void visitDev(Dev dev) {
        var devNoBanco = BancoDev.getInstance().getByCPF(dev.getCpf());
        if (devNoBanco == null) {
            var banco = BancoDev.getInstance();
            banco.add(dev);
            String mensagemSucesso = "Dev " + dev.getNome() + " adicionado com sucesso";
            sendMessageToServer(mensagemSucesso);
        } else {
            sendMessageToServer("Já existe dev com esse cpf");
        }
    }

    @Override
    public void visitEmpresa(Empresa empresa) {
        var empresaNoBanco = BancoEmpresa.getInstance().getByNome(empresa.getNome());
        if (empresaNoBanco == null) {
            var banco = BancoEmpresa.getInstance();
            banco.add(empresa);
            String mensagemSucesso = "Empresa " + empresa.getNome() + " adicionada com sucesso";
            sendMessageToServer(mensagemSucesso);
        } else {
            sendMessageToServer("Já existe empresa com esse mesmo nome");
        }
    }

}