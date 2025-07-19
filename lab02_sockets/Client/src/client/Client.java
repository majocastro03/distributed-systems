package client;

public class Client {
    private final String host;
    private final int port;

    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void run() {
        JSocketClient musicClient = new JSocketClient(host, port);
        musicClient.searchLoop();
    }
}
