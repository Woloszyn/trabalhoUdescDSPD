package cliente.factory;

import cliente.enums.EnumDepartamento;
import cliente.dto.GerenteDTO;

import java.io.BufferedReader;
import java.io.IOException;

public class GerenteDTOFactory extends PessoaFactory implements AbstractFactory<GerenteDTO> {

    @Override
    public GerenteDTO create(BufferedReader bufferedReader, boolean onlyRead, boolean isListar) {
        GerenteDTO gerenteDTO = new GerenteDTO();
        if (!isListar) {
            setAtributosPessoa(gerenteDTO, bufferedReader, onlyRead);
            if (!onlyRead) {
                gerenteDTO.setDepartamento(getDepartamento(bufferedReader));
            }
        }
        return gerenteDTO;
    }

    private EnumDepartamento getDepartamento(BufferedReader bufferedReader) {
        try {
            System.out.println("Departamento digite alguma das opções -> (RECURSOS_HUMANOS, DESENVOLVIMENTO, FINANCAS)");
            String departamento = bufferedReader.readLine().toUpperCase();
            if (departamento.equals("")) {
                return null;
            }
            return EnumDepartamento.fromString(departamento);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (EnumConstantNotPresentException e) {
            System.out.println("Essa opção não está disponível, tente de novo");
            return getDepartamento(bufferedReader);
        }
        return null;
    }
}
