package cliente.command;

import cliente.dto.EntidadeDTO;
import cliente.enums.EnumCommand;

public class ListCommand extends GeneralCommand {


    public ListCommand(EntidadeDTO entidadeDTO) {
        super(entidadeDTO);
    }

    @Override
    public void execute() {
        mensagemDTO.setOperation(EnumCommand.LISTAR);
        enviaMensagem();
    }
}
