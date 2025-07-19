import client.Client;

public class App {
    public static void main(String[] args) {
        Client client = new Client("localhost", 1802);
        client.run();
    }
}
