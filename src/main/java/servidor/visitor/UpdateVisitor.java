package servidor.visitor;

import servidor.banco.BancoDev;
import servidor.banco.BancoEmpresa;
import servidor.banco.BancoGerente;
import servidor.entities.Dev;
import servidor.entities.Empresa;
import servidor.entities.Gerente;

public class UpdateVisitor implements Visitor {

    @Override
    public void visitGerente(Gerente gerente) {
        var gerenteNoBanco = BancoGerente.getInstance().getByCPF(gerente.getCpf());
        if (gerenteNoBanco == null) {
            String mensagemErro = "Gerente não encontrado";
            sendMessageToServer(mensagemErro);
        } else {
            BancoGerente.getInstance().remove(gerenteNoBanco);
            BancoGerente.getInstance().add(gerente);
            String mensagemSucesso = "Gerente " + gerente.getNome() + " alterado com sucesso";
            sendMessageToServer(mensagemSucesso);
        }
    }

    @Override
    public void visitDev(Dev dev) {
        var devNoBanco = BancoDev.getInstance().getByCPF(dev.getCpf());
        if (devNoBanco == null ) {
            String mensagemErro = "Dev não encontrado";
            sendMessageToServer(mensagemErro);
        } else {
            BancoDev.getInstance().remove(devNoBanco);
            BancoDev.getInstance().add(dev);
            String mensagemSucesso = "Dev " + dev.getNome() + " alterado com sucesso";
            sendMessageToServer(mensagemSucesso);
        }
    }

    @Override
    public void visitEmpresa(Empresa empresa) {
        var empresaNoBanco = BancoEmpresa.getInstance().getByNome(empresa.getNome());
        if (empresaNoBanco == null) {
            String mensagemErro = "Empresa não encontrada";
            sendMessageToServer(mensagemErro);
        }
        BancoEmpresa.getInstance().remove(empresaNoBanco);
        BancoEmpresa.getInstance().add(empresa);
        String mensagemSucesso = "Empresa " + empresa.getNome() + " alterada com sucesso";
        sendMessageToServer(mensagemSucesso);
    }
}
