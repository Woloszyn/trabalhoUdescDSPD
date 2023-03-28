package cliente.dto;

import cliente.enums.EnumCommand;
import com.google.gson.annotations.Expose;

public class MensagemDTO<T> {

    @Expose
    T owner;
    @Expose
    EnumCommand operation;
    @Expose
    String entidade;

    public T getOwner() {
        return owner;
    }

    public void setOwner(T owner) {
        this.owner = owner;
    }

    public EnumCommand getOperation() {
        return operation;
    }

    public void setOperation(EnumCommand operation) {
        this.operation = operation;
    }

    public String getEntidade() {
        return entidade;
    }

    public void setEntidade(String entidade) {
        this.entidade = entidade;
    }

    @Override
    public String toString() {
        return "MensagemDTO{" +
                "owner=" + owner.toString() +
                ", operation=" + operation +
                ", entidade='" + entidade + '\'' +
                '}';
    }
}
