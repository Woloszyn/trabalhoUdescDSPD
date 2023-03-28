package servidor.entities;

import cliente.enums.EnumDepartamento;
import com.google.gson.annotations.Expose;
import servidor.visitor.Visitor;

public class Gerente extends Pessoa implements Element {

    @Expose
    EnumDepartamento enumDepartamento;

    public Gerente(String nome, String endereco, String cpf, Double salario, EnumDepartamento enumDepartamento) {
        super(nome, endereco, cpf, salario);
        this.enumDepartamento = enumDepartamento;
    }

    public EnumDepartamento getEnumDepartamento() {
        return enumDepartamento;
    }

    public void setEnumDepartamento(EnumDepartamento enumDepartamento) {
        this.enumDepartamento = enumDepartamento;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitGerente(this);
    }
}
