package org.tudu.app;

/**
 * Handles routes requests and responses.
 *
 */
 
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.OutputStream;
 
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

class RootHandler implements HttpHandler {

	private static HtmlTemplate htmlTemplate = new HtmlTemplate();

	@Override
	public void handle(HttpExchange t) throws IOException, FileNotFoundException {
		String html = htmlTemplate.getHTML();
		t.getResponseHeaders().set("Content-type" , "text/html");
		t.sendResponseHeaders(200 , html.length());
		OutputStream ot = t.getResponseBody();
        ot.write(html.getBytes());
        ot.close();
	}
}