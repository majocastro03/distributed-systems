import service.SongService;
import shared.SongServiceRMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerMain {
    public static void main(String[] args) {
        try {
            SongServiceRMI service = new SongService();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("SongService", service);
            System.out.println("Servidor RMI iniciado");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
