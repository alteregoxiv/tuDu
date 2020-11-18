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
                td.setTodo(todo.replace("+" , " "));
                td.setDescription(description.replace("+" , " "));
                todoList.add(td);
                JsonWriter.getInstance().writeObjectAsJson("todo.json");
                return todoList.size() - 1;
        }

        static int update(String query) {
                List<TodoModel> todoList = JsonReader.getInstance().getTodoList();
                String q[] = query.split("=");
                int id = Integer.parseInt(q[1].split("&")[0]);
                String todo = q[2].split("&")[0];
                String description = q[3];
                todoList.get(id).setTodo(todo.replace("+" , " "));
                todoList.get(id).setDescription(description.replace("+" , " "));
                JsonWriter.getInstance().writeObjectAsJson("todo.json");
                return id;
        }

        static void delete(String[] ids) {
                List<TodoModel> todoList = JsonReader.getInstance().getTodoList();
                for(int i=1 ; i<ids.length ; i++)
                        todoList.remove(Integer.parseInt(ids[i])-i+1);
                JsonWriter.getInstance().writeObjectAsJson("todo.json");
        }
}
