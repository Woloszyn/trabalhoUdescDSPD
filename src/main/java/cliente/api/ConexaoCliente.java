package cliente.api;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class ConexaoCliente {
    public static ConexaoCliente instance;

    public static ConexaoCliente getInstance() {
        if (instance == null) {
            instance = new ConexaoCliente();
        }
        return instance;
    }

    private ConexaoCliente() {
    }

    private Socket conn;

    public void conecta() {
        System.out.println("Iniciando Conexão");
        try {
//            conn = new Socket("192.168.3.7", 8069);
            conn = new Socket("localhost", 8069);
            System.out.println("Conexão estabelecida...");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void recebeMensagem() throws IOException {
        InputStream inputStream = conn.getInputStream();
        byte[] dadosBrutos = new byte[1025];
        inputStream.read(dadosBrutos);
        String dadosStr = new String(dadosBrutos, StandardCharsets.UTF_8).replaceAll("([\\\u0000])", "");
        System.out.println("Servidor: " + dadosStr);
    }

    public boolean verificaMensagem() throws IOException {
        return conn.getInputStream().available() > 0;
    }

    public void enviaMensagem(String mensagem) throws IOException {
        conn.getOutputStream().write(mensagem.getBytes(StandardCharsets.UTF_8));
    }

    public void fechar() throws IOException {
        conn.close();
    }
}