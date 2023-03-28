package cliente.dto;

import cliente.command.GeneralCommand;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class EmpresaDTO implements EntidadeDTO {
    @Expose
    String nome;
    @Expose
    String ramo;

    GeneralCommand generalCommand;
    @Expose
    List<PessoaDTO> funcionarios = new ArrayList<>();

    public EmpresaDTO() {
    }

    public String getNome() {
        return nome;
    }

    public String getRamo() {
        return ramo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRamo(String ramo) {
        this.ramo = ramo;
    }

    public boolean remove(PessoaDTO pessoa) {
        return funcionarios.remove(pessoa);
    }

    public boolean addFuncionario(PessoaDTO pessoaDTO) {
        return funcionarios.add(pessoaDTO);
    }

    @Override
    public void executeCommand() {
        generalCommand.execute();
    }

    @Override
    public void setCommand(GeneralCommand generalCommand) {
        this.generalCommand = generalCommand;
    }
}
