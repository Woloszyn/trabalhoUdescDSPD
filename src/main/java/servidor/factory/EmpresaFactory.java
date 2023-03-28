package servidor.factory;

import com.google.gson.internal.LinkedTreeMap;
import servidor.api.ConexaoServidor;
import servidor.banco.BancoDev;
import servidor.banco.BancoGerente;
import servidor.entities.Dev;
import servidor.entities.Empresa;
import servidor.entities.Gerente;
import servidor.entities.Mensagem;

import java.io.IOException;
import java.util.ArrayList;

public class EmpresaFactory implements EntityAbstractFactory<Empresa> {


    @Override
    public Empresa create(Mensagem mensagem) {
        String nome = (String) ((LinkedTreeMap) mensagem.getOwner()).get("nome");
        String ramo = (String) ((LinkedTreeMap) mensagem.getOwner()).get("ramo");
        Empresa empresa = new Empresa(nome, ramo);
        var pessoas = (ArrayList) ((LinkedTreeMap)mensagem.getOwner()).get("funcionarios");
        pessoas.forEach(pessoa -> {
            String cpf = (String) ((LinkedTreeMap) pessoa).get("cpf");
            Gerente gerenteToAdd = BancoGerente.getInstance().getByCPF(cpf);
            if (gerenteToAdd == null) {
                Dev dev = BancoDev.getInstance().getByCPF(cpf);
                if (dev == null) {
                    try {
                        ConexaoServidor.getInstance().sendMessage("Funcionário informado não existe (CPF " + cpf + ")");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    empresa.addFuncionario(dev);
                }
            } else {
                empresa.addFuncionario(gerenteToAdd);
            }
        });
        return empresa;
    }
}
