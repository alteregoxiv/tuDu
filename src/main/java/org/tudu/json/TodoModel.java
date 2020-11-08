package org.tudu.json;

/**
 *
 * Model class for json object.
 *
 */

public class TodoModel {
	private String todo;
	private String description;

	public TodoModel() {}

	public void setTodo(String todo) {
		this.todo = todo;
	}

	public String getTodo() {
		return todo;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public String toString() {
		return "TodoModel :\n{\ttodo : " + todo + "\n\tdescription : " + description + "\n}";
	}
}
