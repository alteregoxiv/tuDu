package org.tudu.json;

/*
 *
 * Reads JSON and converts to Java object.
 *
 */

import java.io.File;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.core.type.TypeReference;

public class JsonReader {

	private static JsonReader reader = null;
	private static String BASEDIR = System.getenv("DIR");
	private List<TodoModel> todoList = new ArrayList<TodoModel>();
	private static TypeReference<List<TodoModel>> type = new TypeReference<List<TodoModel>>() {};
	private static ObjectMapper objectMapper = new ObjectMapper();

	public static JsonReader getInstance() {
		if (reader == null)
			reader = new JsonReader();
		return reader;
	}

	public List<TodoModel> getTodoList() {
		return todoList;
	}

	public void readJsonAsObject(String fileName) {
		File file = Paths.get(BASEDIR + "/target/" + fileName).toFile();
		try {
			todoList = objectMapper.readValue(file, type);
		} catch(JsonParseException | JsonMappingException ex) {
			System.err.println(ex);
		} catch(IOException ex) {
			System.err.println(ex);
		}
	}
}