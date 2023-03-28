package cliente.dto;

import cliente.command.GeneralCommand;
import com.google.gson.annotations.Expose;

public class PessoaDTO implements EntidadeDTO {

    @Expose
    String nome;

    public GeneralCommand command;

    @Expose
    String endereco;

    @Expose
    String cpf;

    @Expose
    double salario;

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
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

    @Override
    public void executeCommand() {
        command.execute();
    }

    @Override
    public void setCommand(GeneralCommand generalCommand) {
        this.command = generalCommand;
    }
}
