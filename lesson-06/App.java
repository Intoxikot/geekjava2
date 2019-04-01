import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        EchoServer myServer = new EchoServer();
        EchoClient myClient = new EchoClient();

        Scanner sc = new Scanner(System.in);

        while (myClient.isRunning()) {
            String message = sc.nextLine();
            myClient.sendMessage(message); // команда для завершения "/end"
        }
    }
}