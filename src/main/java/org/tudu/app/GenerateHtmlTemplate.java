package org.tudu.app;

/**
 * generates Html templates for rendering.
 *
 */

import java.io.IOException;
import java.util.List;

import org.tudu.json.TodoModel;
import org.tudu.json.JsonReader;

class HtmlTemplate {

	private static HtmlReader reader = new HtmlReader();

	String getHTML() throws IOException {
		String html = reader.readHTML("base.html");
		JsonReader.getInstance().readJsonAsObject("todo.json");
		List<TodoModel> todoList = JsonReader.getInstance().getTodoList();
		for (TodoModel todo : todoList)
			System.out.println(todo);

		return html;
	}
}