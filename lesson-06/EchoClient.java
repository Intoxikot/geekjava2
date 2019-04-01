import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class EchoClient {
        private final String SERVER_ADR = "localhost";
        private final int SERVER_PORT = 8189;

        private Socket socket;
        private DataInputStream in;
        private DataOutputStream out;

        public EchoClient() {
            try {
                openConnection();
            } catch (IOException e) {
                System.out.println("Ошибка соединения");
            }
        }

        public void openConnection() throws IOException {
            socket = new Socket(SERVER_ADR, SERVER_PORT);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String strFromServer = in.readUTF();
                            if (strFromServer.equals("/end")) { // Команда, принимаемая от сервера
                                out.writeUTF("Клиент завершил работу");
                                // System.out.println("Клиент завершил работу");
                                break;
                            }
                            System.out.println("Клиент: " + strFromServer);
                        }
                    } catch(IOException e) {
                        System.out.println("Ошибка работы клиента");
                    }
                }
            }).start();
        }

        public void closeConnection() {
            try {
                in.close();
                out.close();
                socket.close();
                System.out.println("Клиент завершил работу");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void sendMessage(String msg) {
            if (msg.trim().isEmpty())
                return;

            try {
                out.writeUTF(msg);
            } catch (IOException e) {
                System.out.println("Ошибка отправки сообщения");
            }
        }
}
