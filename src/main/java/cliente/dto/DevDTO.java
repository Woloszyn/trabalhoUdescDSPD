package cliente.dto;

import cliente.enums.EnumEspecialidades;
import com.google.gson.annotations.Expose;

public class DevDTO extends PessoaDTO {
    @Expose
    EnumEspecialidades especialidade;

    public EnumEspecialidades getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(EnumEspecialidades especialidade) {
        this.especialidade = especialidade;
    }
}
