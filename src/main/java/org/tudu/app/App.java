package org.tudu.app;

/**
 * Starts and manage server.
 *
 */
 
import java.io.IOException;
import java.net.InetSocketAddress;
 
import com.sun.net.httpserver.HttpServer;
 
public class App {
    
    private final static Integer PORT = Integer.valueOf(System.getenv("PORT"));
    
    public static void main( String[] args ) throws IOException {
    
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT) , 0);

        server.createContext("/", new RootHandler());
        server.createContext("/show", new TodoList());
        // server.createContext("/create", new CreateTodo());
        // server.createContext("/update", new UpdateTodo());
        
        server.setExecutor(null);
        server.start();
        System.out.println("[ Server 🌏 ] listening at port : " + PORT);
    }
}
