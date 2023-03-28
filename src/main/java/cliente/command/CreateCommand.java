package cliente.command;

import cliente.dto.EntidadeDTO;
import cliente.enums.EnumCommand;

public class CreateCommand extends GeneralCommand {


    public CreateCommand(EntidadeDTO entidadeDTO) {
        super(entidadeDTO);
    }

    @Override
    public void execute() {
        mensagemDTO.setOperation(EnumCommand.CREATE);
        enviaMensagem();
    }
}
