package servidor.entities;

import servidor.visitor.Visitor;

public interface Element {
    void accept(Visitor visitor);
}
