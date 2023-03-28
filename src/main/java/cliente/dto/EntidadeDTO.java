package cliente.dto;

import cliente.command.GeneralCommand;

public interface EntidadeDTO {

    public void executeCommand();

    public void setCommand(GeneralCommand generalCommand);

}
