package org.tudu.app;

/**
 * generates Html templates for rendering.
 *
 */

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Formatter;


import org.tudu.json.TodoModel;
import org.tudu.json.JsonReader;

class HtmlTemplate {

	private static HtmlReader reader = new HtmlReader();

	String getBaseHTML() throws IOException {
		String html = reader.readHTML("base.html");
		String todoListHtml = reader.readHTML("todo.html");
		JsonReader.getInstance().readJsonAsObject("todo.json");
		List<TodoModel> todoList = JsonReader.getInstance().getTodoList();
		System.out.println(todoList);

		html = html.replace("{{title}}", "Todo List | TuDu");
		String todos = "<input type = \"hidden\" name = \"empty\" value=\"\"> <br>";
		if (todoList.size() > 0) {
			int size = todoList.size();
			for (int i = 0; i < size; i++)
				todos += String.format("<input type=\"checkbox\" name = \"todo\" value = \"%d\"> %s <br>", i, todoList.get(i).getTodo());
			todos += "<button class = \"button btn-danger\" formaction = \"/delete\">Mark Done</button>";
			todos += "<button class = \"button btn-success\" formaction = \'/show-todos\'>Show</button>";
		}
		else {
			todos = "<h2> You\'re all caught up. + Add todos to see them here. </h2>";
		}

		html = html.replace("{{bodyContents}}", todoListHtml.replace("{{todos}}", todos));
		System.out.println(todos + "\n\n\n");
		System.out.println(html + "\n\n\n");
		return html;
	}
}