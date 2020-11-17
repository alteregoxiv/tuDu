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

	@Override
	public void handle(HttpExchange t) throws IOException, FileNotFoundException {
		String html = HtmlTemplate.getInstance().getBaseHTML();
		t.getResponseHeaders().set("Content-type" , "text/html");
		t.sendResponseHeaders(200 , html.length());
		OutputStream ot = t.getResponseBody();
        ot.write(html.getBytes());
        ot.close();
	}
}

class TodoList implements HttpHandler{

	@Override
	public void handle(HttpExchange t) throws IOException, FileNotFoundException {
		String query[] = t.getRequestURI().getQuery().split("&todo=");
		String html = HtmlTemplate.getInstance().getViewPage(query);
		t.getResponseHeaders().set("Content-type" , "text/html");
		t.sendResponseHeaders(200 , html.length());
		OutputStream ot = t.getResponseBody();
        ot.write(html.getBytes());
        ot.close();
	}

}

class CreateTodo implements HttpHandler {

	@Override
	public void handle(HttpExchange t) throws IOException, FileNotFoundException {
		String html = HtmlTemplate.getInstance().getCreatePage();
		t.getResponseHeaders().set("Content-type" , "text/html");
		t.sendResponseHeaders(200 , html.length());
		OutputStream ot = t.getResponseBody();
        ot.write(html.getBytes());
        ot.close();
	}
}