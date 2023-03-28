package servidor.factory;

import servidor.entities.Mensagem;

public interface EntityAbstractFactory<Element> {
    Element create(Mensagem mensagem);
}
