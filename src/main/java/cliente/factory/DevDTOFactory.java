package cliente.factory;

import cliente.dto.DevDTO;
import cliente.enums.EnumEspecialidades;

import java.io.BufferedReader;
import java.io.IOException;

public class DevDTOFactory extends PessoaFactory implements AbstractFactory<DevDTO> {
    @Override
    public DevDTO create(BufferedReader bufferedReader, boolean onlyRead, boolean isListar) {
        DevDTO devDTO = new DevDTO();
        if (!isListar) {
            setAtributosPessoa(devDTO, bufferedReader, onlyRead);
            if (!onlyRead) {
                devDTO.setEspecialidade(getEspecialidade(bufferedReader));
            }
        }
        return devDTO;
    }

    private EnumEspecialidades getEspecialidade(BufferedReader bufferedReader) {
        System.out.println("Especialidade(BACKEND, FRONTEND, DEVOPS)");
        try {
            String especialidade = bufferedReader.readLine().toUpperCase();
            if (especialidade.equals("")) {
                return null;
            }
            return EnumEspecialidades.fromString(especialidade);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (EnumConstantNotPresentException e) {
            System.out.println("Essa opção não está disponível, tente novamente");
            return getEspecialidade(bufferedReader);
        }
        return null;
    }

}
