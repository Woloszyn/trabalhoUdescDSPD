package servidor.api;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ConexaoServidor {
    Socket conn;
    ServerSocket server;
    private static ConexaoServidor instance;

    public static ConexaoServidor getInstance() throws IOException {
        if (instance == null) {
            instance = new ConexaoServidor();
        }
        return instance;
    }

    private ConexaoServidor() throws IOException {
        server = new ServerSocket(8069);
        server.setReuseAddress(true);
    }

    public void startServer() {
        try {
            System.out.println("Abrindo conexão");
            conn = server.accept();
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    public String readMessage() throws IOException {
        if (hasMessage()) {
            InputStream inputStream = conn.getInputStream();
            byte[] dadosBrutos = new byte[1025];
            inputStream.read(dadosBrutos);
            String dadosStr = new String(dadosBrutos, StandardCharsets.UTF_8).replaceAll("([\\\u0000])", "");
            System.out.println(conn.getInetAddress().getHostAddress() + ": " + dadosStr);
            return dadosStr;
        }
        return null;
    }

    public void sendMessage(String mensagem) {
        OutputStream outputStream = null;
        try {
            outputStream = conn.getOutputStream();
            outputStream.write(mensagem.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean hasMessage() throws IOException {
        return conn.getInputStream().available() > 0;
    }

    public void close() throws IOException {
        conn.close();
    }
}
