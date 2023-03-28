package servidor.factory;

import cliente.enums.EnumDepartamento;
import com.google.gson.internal.LinkedTreeMap;
import servidor.entities.Gerente;
import servidor.entities.Mensagem;

public class GerenteFactory implements EntityAbstractFactory<Gerente> {


    @Override
    public Gerente create(Mensagem mensagem) {
        String cpf = (String) ((LinkedTreeMap) mensagem.getOwner()).get("cpf");
        String nome = (String) ((LinkedTreeMap) mensagem.getOwner()).get("nome");
        Double salario = (Double) ((LinkedTreeMap) mensagem.getOwner()).get("salario");
        String endereco = (String) ((LinkedTreeMap) mensagem.getOwner()).get("endereco");
        String departamento = (String) ((LinkedTreeMap) mensagem.getOwner()).get("departamento");
        EnumDepartamento enumDepartamento = null;
        if (departamento != null && !departamento.equals("")) {
            enumDepartamento = EnumDepartamento.fromString(departamento);
        }
        return new Gerente(nome, endereco, cpf, salario, enumDepartamento);
    }
}
