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
        static void create(String todo, String description) {
                List<TodoModel> todoList = JsonReader.getInstance().getTodoList();
                TodoModel td = new TodoModel();
                td.setTodo(todo);
                td.setDescription(description);
                todoList.add(td);
                JsonWriter.getInstance().writeObjectAsJson("tud.json");
        }

        static void update(int id, String todo, String description) {

        }

        static void delete(String[] ids) {

        }
}
