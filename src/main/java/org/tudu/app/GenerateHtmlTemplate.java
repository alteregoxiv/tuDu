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
	private static HtmlTemplate htmlTemplate = null;

	static HtmlTemplate getInstance() {
		if (htmlTemplate == null)
			htmlTemplate = new HtmlTemplate();
		return htmlTemplate;
	}

	String getBaseHTML() throws IOException {
		String html = reader.readHTML("base.html");
		String todoListHtml = reader.readHTML("todo.html");
		JsonReader.getInstance().readJsonAsObject("todo.json");
		List<TodoModel> todoList = JsonReader.getInstance().getTodoList();

		html = html.replace("{{title}}", "Todo List | TuDu");
		String todos = "<input type = \"hidden\" name = \"empty\" value=\"\"> <br>";
		if (todoList.size() > 0) {
			int size = todoList.size();
			for (int i = 0; i < size; i++)
				todos += String.format("<input type=\"checkbox\" name = \"todo\" value = \"%d\"> %s <br>", i, todoList.get(i).getTodo());
			todos += "<button class = \"button btn-danger\" formaction = \"/delete\">Mark Done</button>";
			todos += "<button class = \"button btn-success\" formaction = \'/show\'>Show</button>";
		}
		else {
			todos = "<h2> You\'re all caught up. + Add todos to see them here. </h2>";
		}

		html = html.replace("{{bodyContents}}", todoListHtml.replace("{{todos}}", todos));
		return html;
	}

	String getViewPage(String []query) throws IOException {
		String html = reader.readHTML("base.html");
		String view = reader.readHTML("view.html");
		List<TodoModel> todoList = JsonReader.getInstance().getTodoList();

		html = html.replace("{{title}}", "Show Todo | TuDu");
		String todos = new String();
		if(query.length==1)
			todos += "<h1>Nothing Selected...Please Select One to View the Todo...</h1>";
		else{

			for(int i=1 ; i<query.length ; i++){
				TodoModel td = todoList.get(Integer.parseInt(query[i]));
				String todo = view.replace("{{todo}}", td.getTodo());
				todo = todo.replace("{{value}}", query[i]);
				todos += todo.replace("{{desc}}", td.getDescription());
			}
		}
		html = html.replace("{{bodyContents}}", todos);
		return html;
	}

	String getCreatePage() throws IOException {
		String html = reader.readHTML("base.html");
		String createPage = reader.readHTML("create.html");
		html = html.replace("{{title}}", "Create Todo | TuDu");
		html = html.replace("{{bodyContents}}", createPage);
		return html;
	}

	String getUpdatePage(String id) throws IOException{
		String html = reader.readHTML("base.html");
		String view = reader.readHTML("update.html");
		List<TodoModel> todoList = JsonReader.getInstance().getTodoList();

		html = html.replace("{{title}}", "Update Todo | TuDu");
                view = view.replace("{{id}}", id);
		TodoModel td = todoList.get(Integer.parseInt(id));
		view = view.replace("{{todo}}" , td.getTodo());
		view = view.replace("{{desc}}" , td.getDescription());
		html = html.replace("{{bodyContents}}" , view);
		return html;
	}
}
