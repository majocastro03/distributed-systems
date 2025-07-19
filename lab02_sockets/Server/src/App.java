import server.Server;

public class App {
    public static void main(String[] args) {
        Server server = new Server(1802);
        server.run();
    }
}
