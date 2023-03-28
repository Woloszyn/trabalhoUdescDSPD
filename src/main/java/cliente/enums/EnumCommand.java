package cliente.enums;

import cliente.command.*;
import cliente.dto.EntidadeDTO;

public enum EnumCommand {

    CREATE(1),
    READ(2),
    UPDATE(3),
    DELETE(4),
    LISTAR(5);

    public final int valorEscolhido;


    EnumCommand(int valorEscolhido) {
        this.valorEscolhido = valorEscolhido;
    }

    public static EnumCommand getFromInt(int i) throws ClassNotFoundException {
        switch (i) {
            case 1: return CREATE;
            case 2: return READ;
            case 3: return UPDATE;
            case 4: return DELETE;
            case 5: return LISTAR;
        }
        throw new ClassNotFoundException();
    }

    public GeneralCommand getGeneralCommand(EntidadeDTO entidadeDTO) {
        switch (this) {
            case CREATE: return new CreateCommand(entidadeDTO);
            case READ: return new ReadCommand(entidadeDTO);
            case UPDATE: return new UpdateCommand(entidadeDTO);
            case DELETE: return new DeleteCommand(entidadeDTO);
            case LISTAR: return new ListCommand(entidadeDTO);
        }
        return null;
    }

}
