package com.server;

import com.server.interfaces.SongLibraryInterface;
import com.server.service.SongLibraryService;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

public class Server {
    public static void main(String[] args) {
        JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
        factory.setServiceClass(SongLibraryInterface.class);
        factory.setServiceBean(new SongLibraryService());
        factory.setAddress("http://localhost:8081/server");
        factory.create();
        System.out.println("Servidor SOAP iniciado en http://localhost:8081/server?wsdl");
    }
}
