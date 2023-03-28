package cliente.api;

import cliente.enums.EnumCommand;
import cliente.dto.EntidadeDTO;
import cliente.factory.AbstractFactory;
import cliente.enums.EnumFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        ConexaoCliente conexaoCliente = ConexaoCliente.getInstance();
        conexaoCliente.conecta();
        boolean letsContinue = true;
        while (letsContinue) {
            try {
                var bufferReader = new BufferedReader(new InputStreamReader(System.in));
                EnumCommand enumCommand = createEnumCommand(bufferReader);
                var dto = createDTO(bufferReader, enumCommand);
                var command = enumCommand.getGeneralCommand(dto);
                if (dto != null) {
                    dto.setCommand(command);
                    dto.executeCommand();
                }
                System.out.println("Recebendo resposta do servidor....");
                recebeMensagem();
                System.out.println("Para sair digite \"exit\" \nPara continuar digite qualquer outra coisa");
                letsContinue = !bufferReader.readLine().equalsIgnoreCase("exit");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Finalizando conexão .....");
        conexaoCliente.fechar();
        System.exit(0);
    }

    private static void recebeMensagem() {
        while (true) {
            try {
                if (ConexaoCliente.getInstance().verificaMensagem()) {
                    ConexaoCliente.getInstance().recebeMensagem();
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    private static EnumCommand createEnumCommand(BufferedReader bufferReader) throws ClassNotFoundException, IOException {
        System.out.println("Escolha a operação (SOMENTE NÚMERO)");
        System.out.println("1. CREATE");
        System.out.println("2. GET");
        System.out.println("3. UPDATE");
        System.out.println("4. DELETE");
        System.out.println("5. LISTAR");
        int escolha = Integer.parseInt(bufferReader.readLine());
        return EnumCommand.getFromInt(escolha);
    }

    private static EntidadeDTO createDTO(BufferedReader bufferReader, EnumCommand enumCommand) throws IOException, ClassNotFoundException {
        AbstractFactory factory;
        System.out.println("Escolha a entidade que deseja aplicar (SOMENTE NÚMERO)");
        System.out.println("1. DEV");
        System.out.println("2. Gerente");
        System.out.println("3. Empresa");
        int escolha = Integer.parseInt(bufferReader.readLine());
        EnumFactory enumFactory = EnumFactory.fromInteger(escolha);
        factory = enumFactory.getAbstractFactory();
        EntidadeDTO dto = null;
        if (factory != null) {
            dto = (EntidadeDTO) factory.create(bufferReader, enumCommand.equals(EnumCommand.READ)
                    || enumCommand.equals(EnumCommand.DELETE), enumCommand.equals(EnumCommand.LISTAR));
        }
        return dto;
    }
}
