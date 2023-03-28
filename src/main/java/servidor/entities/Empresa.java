package servidor.entities;

import com.google.gson.annotations.Expose;
import servidor.visitor.Visitor;

import java.util.ArrayList;
import java.util.List;

public class Empresa implements Element {

    @Expose
    String nome;
    @Expose
    String ramo;
    @Expose
    List<Pessoa> funcionarios = new ArrayList<>();

    public Empresa(String nome, String ramo) {
        this.nome = nome;
        this.ramo = ramo;
    }

    public String getNome() {
        return nome;
    }

    public String getRamo() {
        return ramo;
    }

    public void addFuncionario(Pessoa pessoa) {
        funcionarios.add(pessoa);
    }

    public List<Pessoa> getFuncionarios() {
        return funcionarios;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitEmpresa(this);
    }
}
