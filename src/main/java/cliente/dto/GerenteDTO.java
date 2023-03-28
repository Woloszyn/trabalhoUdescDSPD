package cliente.dto;

import cliente.enums.EnumDepartamento;
import com.google.gson.annotations.Expose;

public class GerenteDTO extends PessoaDTO{

    @Expose
    EnumDepartamento departamento;

    public EnumDepartamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(EnumDepartamento departamento) {
        this.departamento = departamento;
    }
}
