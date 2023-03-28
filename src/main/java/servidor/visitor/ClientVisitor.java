package servidor.visitor;

import servidor.entities.Mensagem;

public class ClientVisitor {

    public Visitor createFromMessage(Mensagem mensagem) {
        switch (mensagem.getOperation()) {
            case CREATE:
                return new CreateVisitor();
            case DELETE:
                return new DeleteVisitor();
            case UPDATE:
                return new UpdateVisitor();
            case READ:
                return new ReadVisitor();
            case LISTAR:
                return new ListarVisitor();
        }
        return null;
    }

}
