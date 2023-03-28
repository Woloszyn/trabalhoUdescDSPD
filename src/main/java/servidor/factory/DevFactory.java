package servidor.factory;

import com.google.gson.internal.LinkedTreeMap;
import servidor.entities.Dev;
import servidor.entities.EnumEspecialidades;
import servidor.entities.Mensagem;

public class DevFactory implements EntityAbstractFactory<Dev> {

    @Override
    public Dev create(Mensagem mensagem) {
        String cpf = (String) ((LinkedTreeMap) mensagem.getOwner()).get("cpf");
        String nome = (String) ((LinkedTreeMap) mensagem.getOwner()).get("nome");
        Double salario = (Double) ((LinkedTreeMap) mensagem.getOwner()).get("salario");
        String endereco = (String) ((LinkedTreeMap) mensagem.getOwner()).get("endereco");
        String especialidade = (String) ((LinkedTreeMap) mensagem.getOwner()).get("especialidade");
        Dev dev = null;
        EnumEspecialidades enumEspecialidades = null;
        try {
            if (especialidade != null && !especialidade.equals("")) {
                enumEspecialidades = EnumEspecialidades.fromString(especialidade);
            }
            dev = new Dev(nome, endereco, cpf, salario, enumEspecialidades);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return dev;
    }

}
