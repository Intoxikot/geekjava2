
public class App {

    public static void main(String[] args) {

        EchoServer myServer = new EchoServer();
        EchoClient myClient = new EchoClient();

        myClient.sendMessage("сообщение1");
        myClient.sendMessage("сообщение2");
        myClient.sendMessage("сообщение3");
        myClient.sendMessage("/end");

    }
}