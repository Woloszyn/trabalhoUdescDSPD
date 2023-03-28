package servidor.entities;

import com.google.gson.annotations.Expose;
import servidor.visitor.Visitor;

public class Dev extends Pessoa implements Element {

    @Expose
    EnumEspecialidades especialidade;

    public Dev(String nome, String endereco, String cpf, Double salario, EnumEspecialidades especialidade) {
        super(nome, endereco, cpf, salario);
        this.especialidade = especialidade;
    }

    public EnumEspecialidades getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(EnumEspecialidades especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitDev(this);
    }
}
