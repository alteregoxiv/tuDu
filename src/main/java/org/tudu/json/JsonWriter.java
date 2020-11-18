package org.tudu.json;

/*
 *
 *  Converts and writes Java objects as JSON
 *
 */

import java.io.File;

public class JsonWriter {
        private static JsonWriter writer = null;
        private static String BASEDIR = System.getenv("DIR");
        private static ObjectMapper objectMapper = new ObjectMapper();

        public static JsonWriter getInstance() {
                if (writer == null)
                        writer = new JsonWriter();
                return writer;
        }

        public void writeObjectAsJson(String filename) {
                List<TodoModel> todoList = JsonReader.getInstance().getTodoList();
                File file = new File(BASEDIR + "/target/" + filename);
        }
}
