package cliente.command;

import cliente.dto.*;
import cliente.enums.EnumCommand;

public class DeleteCommand extends GeneralCommand {


    public DeleteCommand(EntidadeDTO entidadeDTO) {
        super(entidadeDTO);
    }

    @Override
    public void execute() {
        mensagemDTO.setOperation(EnumCommand.DELETE);
        enviaMensagem();
    }

}
