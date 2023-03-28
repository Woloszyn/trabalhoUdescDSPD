package servidor.banco;

import servidor.entities.Empresa;

public class BancoEmpresa extends Banco<Empresa>{

    private static BancoEmpresa instance;

    public static BancoEmpresa getInstance() {
        if (instance == null) {
            instance = new BancoEmpresa();
        }
        return instance;
    }

    private BancoEmpresa() {
    }
    
    public Empresa getByNome(String nome) {
        var registros = this.getArrayListEntidade();
        var registroOptional = registros.stream().filter(h -> h.getNome().equals(nome)).findFirst();
        if (registroOptional.isEmpty()) {
            return null;
        }
        return registroOptional.get();
    }

}
