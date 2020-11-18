package org.tudu.json;

/*
 *
 *  Converts and writes Java objects as JSON
 *
 */

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonWriter {
        private static JsonWriter writer = null;
        private static String BASEDIR = System.getenv("DIR");
        private static ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

        public static JsonWriter getInstance() {
                if (writer == null)
                        writer = new JsonWriter();
                return writer;
        }

        public void writeObjectAsJson(String filename) {
                List<TodoModel> todoList = JsonReader.getInstance().getTodoList();
                File file = new File(BASEDIR + "/target/" + filename);
                try {
			todoList = objectMapper.writeValueAsString(file, todoList);
		} catch(JsonParseException | JsonMappingException ex) {
			System.err.println(ex);
		} catch(IOException ex) {
			System.err.println(ex);
		}
        }
}
