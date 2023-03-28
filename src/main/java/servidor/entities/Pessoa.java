package servidor.entities;

import com.google.gson.annotations.Expose;

public class Pessoa {
    @Expose
    String nome;
    @Expose
    String endereco;
    @Expose
    String cpf;
    @Expose
    Double salario;
    Empresa empresa;

    public Pessoa(String nome, String endereco, String cpf, Double salario) {
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.salario = salario;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }

}
