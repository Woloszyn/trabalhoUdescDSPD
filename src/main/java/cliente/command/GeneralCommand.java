package cliente.command;

import cliente.api.ConexaoCliente;
import cliente.dto.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

public abstract class GeneralCommand {

    EntidadeDTO entidadeDTO;
    MensagemDTO mensagemDTO;

    public GeneralCommand(EntidadeDTO entidadeDTO) {
        this.entidadeDTO = entidadeDTO;
        mensagemDTO = new MensagemDTO<>();
        mensagemDTO.setOwner(entidadeDTO);
        mensagemDTO.setEntidade(entidadeDTO.getClass().getCanonicalName());
    }

    protected String getMensagem() {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        return gson.toJson(mensagemDTO);
    }

    protected void enviaMensagem() {
        try {
            String mensagem = getMensagem();
            ConexaoCliente.getInstance().enviaMensagem(mensagem);
            System.out.println("Mensagem enviada ao servidor -> " + mensagem);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public abstract void execute();

}
