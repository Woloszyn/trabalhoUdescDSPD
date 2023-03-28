package servidor.banco;

import servidor.entities.Gerente;

import java.util.Optional;

public class BancoGerente extends Banco<Gerente> {

    private static BancoGerente instance;

    public static BancoGerente getInstance() {
        if (instance == null) {
            instance = new BancoGerente();
        }
        return instance;
    }

    private BancoGerente() {
    }
    
    public Gerente getByCPF(String cpf) {
        var registros = this.getArrayListEntidade();
        Optional<Gerente> registroOptional = registros.stream().filter(h -> h.getCpf().equals(cpf)).findFirst();
        if (registroOptional.isEmpty()) {
            return null;
        }
        return registroOptional.get();
    }

}
