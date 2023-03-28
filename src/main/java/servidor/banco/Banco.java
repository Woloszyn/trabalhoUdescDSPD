package servidor.banco;

import java.util.ArrayList;
import java.util.List;

public class Banco<T> {

    List<T> arrayListEntidade = new ArrayList<>();

    public void add(T entidade) {
        arrayListEntidade.add(entidade);
    }

    public void remove(T entidade) {
        arrayListEntidade.remove(entidade);
    }

    public List<T> getArrayListEntidade() {
        return arrayListEntidade;
    }

}