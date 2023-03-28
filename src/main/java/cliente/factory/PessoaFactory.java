package cliente.factory;

import cliente.dto.PessoaDTO;

import java.io.BufferedReader;
import java.io.IOException;

public abstract class PessoaFactory {
    
    protected void setAtributosPessoa(PessoaDTO pessoa, BufferedReader bufferedReader, boolean onlyRead) {
        try {
            if (!onlyRead) {
                System.out.println("Nome");
                pessoa.setNome(bufferedReader.readLine());
                System.out.println("Endereco");
                pessoa.setEndereco(bufferedReader.readLine());
                System.out.println("Salário");
                String salario = bufferedReader.readLine();
                if (!salario.equals("")) {
                    pessoa.setSalario(Double.parseDouble(salario));
                }
            }
            System.out.println("CPF");
            pessoa.setCpf(bufferedReader.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
