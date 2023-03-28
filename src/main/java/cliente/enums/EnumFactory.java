package cliente.enums;

import cliente.factory.AbstractFactory;
import cliente.factory.DevDTOFactory;
import cliente.factory.EmpresaDTOFactory;
import cliente.factory.GerenteDTOFactory;

public enum EnumFactory {
    DEV(1),
    GERENTE(2),
    EMPRESA(3);

    public final int valorEquivalente;
    private EnumFactory(int i) {
        valorEquivalente = i;
    }

    public static EnumFactory fromInteger(int i) throws ClassNotFoundException {
        switch (i) {
            case 1: return DEV;
            case 2: return GERENTE;
            case 3: return EMPRESA;
            default: throw new ClassNotFoundException();
        }
    }

    public AbstractFactory getAbstractFactory() {
        switch (this) {
            case DEV:
                return new DevDTOFactory();
            case GERENTE:
                return new GerenteDTOFactory();
            case EMPRESA:
                return new EmpresaDTOFactory();
        }
        return null;
    }

}
