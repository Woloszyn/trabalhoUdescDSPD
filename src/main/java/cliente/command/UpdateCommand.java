package cliente.command;

import cliente.dto.EntidadeDTO;
import cliente.enums.EnumCommand;

public class UpdateCommand extends GeneralCommand {


    public UpdateCommand(EntidadeDTO entidadeDTO) {
        super(entidadeDTO);
    }

    @Override
    public void execute() {
        mensagemDTO.setOperation(EnumCommand.UPDATE);
        enviaMensagem();
    }
}
