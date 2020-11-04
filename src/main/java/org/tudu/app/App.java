package org.tudu.app;

/**
 * Hello world!
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
    private final static String BASEDIR = System.getenv("DIR");
    
    public static void main( String[] args ) throws IOException {
    
        HttpServer server = HttpServer.create(new InetSocketAddress(PORT) , 0);

        server.createContext("/", new HttpHandler() {
        	@Override
        	public void handle(HttpExchange t) throws IOException, FileNotFoundException {
        		File file = new File(System.getenv("DIR") + "/todo.html");
        		FileReader fr = new FileReader(file);
        		BufferedReader in = new BufferedReader(fr);
        		String data = new String();
        		String s;
        		while ((s = in.readLine()) != null)
        			data += s;
        		System.out.println(data);
        		
        		t.getResponseHeaders().set("Content-type" , "text/html");
        		t.sendResponseHeaders(200 , data.length());
        		OutputStream ot = t.getResponseBody();
                ot.write(data.getBytes());
                ot.close();
        	}
        });
        
        server.setExecutor(null);
        server.start();
        System.out.println("[ Server  ☑✔✅] listening at port : " + PORT);
        
    }
}
