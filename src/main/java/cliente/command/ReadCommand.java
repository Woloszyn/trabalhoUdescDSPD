package cliente.command;

import cliente.dto.*;
import cliente.enums.EnumCommand;

public class ReadCommand extends GeneralCommand {


    public ReadCommand(EntidadeDTO entidadeDTO) {
        super(entidadeDTO);
    }

    @Override
    public void execute() {
        mensagemDTO.setOperation(EnumCommand.READ);
        enviaMensagem();
    }
}
