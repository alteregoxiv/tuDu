package org.tudu.app;

/**
 * Starts and manage server.
 *
 */
 
import java.io.IOException;
import java.net.InetSocketAddress;
import java.io.FileReader;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.OutputStream;
 
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
 
public class App {
    
    private final static Integer PORT = Integer.valueOf(System.getenv("PORT"));
    
    public static void main( String[] args ) throws IOException {
    
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT) , 0);

        server.createContext("/", new RootHandler());
        
        server.setExecutor(null);
        server.start();
        System.out.println("[ Server 🌏 ] listening at port : " + PORT);
    }
}
