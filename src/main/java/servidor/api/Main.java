package servidor.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import servidor.entities.Mensagem;
import servidor.factory.ClientEntityFactory;
import servidor.visitor.ClientVisitor;
import servidor.entities.Element;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        ConexaoServidor conexaoServidor = ConexaoServidor.getInstance();
        while (true) {
            try {
                conexaoServidor.startServer();
                recebeMensagem();
            }catch (Exception e) {
                System.err.println(e);
                throw e;
            }
        }
    }

//    private static void recebeMensagem() {
//        while (true) {
//                    try {
//                        ConexaoServidor conexaoServidor = ConexaoServidor.getInstance();
//                        String mensagemRecebida = conexaoServidor.readMessage();
//                        if (mensagemRecebida != null){
//                            Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
//                            System.out.println(mensagemRecebida);
//                            Mensagem mensagem = gson.fromJson(mensagemRecebida, Mensagem.class);
//                            var clientEntityFactory = new ClientEntityFactory();
//                            var clientVisitor = new ClientVisitor();
//                            var factory = clientEntityFactory.createFromMessage(mensagem);
//                            var visitor = clientVisitor.createFromMessage(mensagem);
//                            var entity = (Element) factory.create(mensagem);
//                            entity.accept(visitor);
//                        }
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//    }

    private static void recebeMensagem() {
        new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        ConexaoServidor conexaoServidor = ConexaoServidor.getInstance();
                        String mensagemRecebida = conexaoServidor.readMessage();
                        if (mensagemRecebida != null){
                            Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
                            System.out.println(mensagemRecebida);
                            Mensagem mensagem = gson.fromJson(mensagemRecebida, Mensagem.class);
                            var clientEntityFactory = new ClientEntityFactory();
                            var clientVisitor = new ClientVisitor();
                            var factory = clientEntityFactory.createFromMessage(mensagem);
                            var visitor = clientVisitor.createFromMessage(mensagem);
                            var entity = (Element) factory.create(mensagem);
                            entity.accept(visitor);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

}
