import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;

    public EchoServer() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                runServer();
            }
        }).start();
    }

    private void runServer() {
        Socket socket = null;
        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Сервер запущен");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            while (true) {
                String str = in.readUTF();
                if (str.equals("/end")) { // Команда, принимаемая от клиента
                    out.writeUTF("Сервер завершил работу");
                    break;
                }
                out.writeUTF("Сервер: " + str);
                // System.out.println("Сервер: " + str); // Сообщения на стороне сервера
            }
        } catch (IOException e) {
            System.out.println("Сервер вышел из строя");
        }
    }
}