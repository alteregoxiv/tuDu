package org.tudu.app;

/*
 *
 *  Updates the Todo List for create, update or delete requests
 *
 */

import java.util.List;
import java.util.ArrayList;

import org.tudu.json.TodoModel;
import org.tudu.json.JsonReader;
import org.tudu.json.JsonWriter;

class ModifyTodoList {
        static int create(String query) {
                List<TodoModel> todoList = JsonReader.getInstance().getTodoList();
                TodoModel td = new TodoModel();
                String q[] = query.split("=");
                String todo = q[1].split("&")[0];
                String description = q[2];
                td.setTodo(todo);
                td.setDescription(description);
                todoList.add(td);
                JsonWriter.getInstance().writeObjectAsJson("todo.json");
                return todoList.size() - 1;
        }

        static int update(String query) {
                return 0;
        }

        static void delete(String[] ids) {

        }
}
