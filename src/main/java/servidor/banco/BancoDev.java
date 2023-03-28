package servidor.banco;

import servidor.entities.Dev;

public class BancoDev extends Banco<Dev> {

    private static BancoDev instance;

    public static BancoDev getInstance() {
        if (instance == null) {
            instance = new BancoDev();
        }
        return instance;
    }

    private BancoDev() {
    }

    public Dev getByCPF(String cpf) {
        var registros = this.getArrayListEntidade();
        var registroOptional = registros.stream().filter(h -> h.getCpf().equals(cpf)).findFirst();
        if (registroOptional.isEmpty()) {
            return null;
        }
        return registroOptional.get();
    }
}
