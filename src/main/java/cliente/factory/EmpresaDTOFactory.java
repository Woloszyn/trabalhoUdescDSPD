package cliente.factory;

import cliente.dto.EmpresaDTO;
import cliente.dto.PessoaDTO;

import java.io.BufferedReader;
import java.io.IOException;

public class EmpresaDTOFactory implements AbstractFactory<EmpresaDTO> {
    @Override
    public EmpresaDTO create(BufferedReader bufferedReader, boolean onlyRead, boolean isListar) {
        EmpresaDTO empresaDTO = new EmpresaDTO();
        if (!isListar) {
            try {
                System.out.println("Nome da empresa:");
                String nomeEmpresa = bufferedReader.readLine();
                empresaDTO.setNome(nomeEmpresa);
                if (!onlyRead) {
                    System.out.println("Ramo da empresa:");
                    String ramo = bufferedReader.readLine();
                    empresaDTO.setRamo(ramo);
                    var continuaAdicionandoPessoa = true;
                    while (continuaAdicionandoPessoa) {
                        System.out.println("Adicionar pessoa à empresa? (Somente números)");
                        System.out.println("1. Adicionar DEV");
                        System.out.println("2. Adicionar Gerente");
                        System.out.println("3. Cancelar");
                        int escolha = Integer.parseInt(bufferedReader.readLine());
                        PessoaDTO pessoa = null;
                        switch (escolha) {
                            case 1:
                                pessoa = new DevDTOFactory().create(bufferedReader, true, false);
                                empresaDTO.addFuncionario(pessoa);
                                break;
                            case 2:
                                pessoa = new GerenteDTOFactory().create(bufferedReader, true, false);
                                empresaDTO.addFuncionario(pessoa);
                                break;
                            case 3:
                                continuaAdicionandoPessoa = false;
                                break;
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return empresaDTO;
    }
}
