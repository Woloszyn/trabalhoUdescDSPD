package servidor.entities;

import com.google.gson.annotations.Expose;

public class Mensagem<T> {

    @Expose
    T owner;
    @Expose
    EnumOperations operation;
    @Expose
    String entidade;

    public T getOwner() {
        return owner;
    }

    public void setOwner(T owner) {
        this.owner = owner;
    }

    public EnumOperations getOperation() {
        return operation;
    }

    public void setOperation(EnumOperations operation) {
        this.operation = operation;
    }

    public String getEntidade() {
        return entidade;
    }

    public void setEntidade(String entidade) {
        this.entidade = entidade;
    }
}
