import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private boolean work = false;
    private Thread threadServer;

    public EchoServer() {
        threadServer = new Thread(new Runnable() {
            @Override
            public void run() {
                work = true;
                runServer();
            }
        });
        threadServer.start();
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
                    System.out.println("Сервер завершил работу");
                    out.writeUTF("/end"); // Сервер в свою очередь при отключении уведомляет клиент и направляет встречную команду
                    terminateServer();
                    break;
                }
                out.writeUTF("Сервер: " + str);
                // System.out.println("Сервер: " + str); // Сообщения на стороне сервера
            }
        } catch (IOException e) {
            System.out.println("Сервер вышел из строя");
        }
    }

    public void terminateServer() {
        try {
            in.close();
            out.close();
            work = false;
            // threadServer.interrupt();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isRunning() {
        return work;
    }
}