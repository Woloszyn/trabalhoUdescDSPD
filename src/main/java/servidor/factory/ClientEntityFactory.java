package servidor.factory;

import servidor.entities.Mensagem;

public class ClientEntityFactory {

    EntityAbstractFactory entityAbstractFactory;

    public EntityAbstractFactory createFromMessage(Mensagem mensagem) throws Exception {
        if (mensagem.getEntidade().toUpperCase().contains("DEV")) {
            return new DevFactory();
        }
        if (mensagem.getEntidade().toUpperCase().contains("GERENTE")) {
            return new GerenteFactory();
        }
        if (mensagem.getEntidade().toUpperCase().contains("EMPRESA")) {
            return new EmpresaFactory();
        }
        throw new Exception("Erro ao criar a factory");
    }

}
