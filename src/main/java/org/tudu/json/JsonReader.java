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
		System.out.println("instance");
		if (reader == null)
			reader = new JsonReader();
		return reader;
	}

	public List<TodoModel> getTodoList() {
		return todoList;
	}

	public void readJsonAsObject(String fileName) {
		File file = Paths.get(BASEDIR + "/target/" + fileName).toFile();
		System.out.println(BASEDIR + "/target/" + fileName);
		// String file = "{\"todo\" : \"1st Instance\", \"description\" : \"JsonReader.getInstance(1)\"}";
		System.out.println(file);
		// try {
		// TodoModel todo = objectMapper.readValue(file, TodoModel.class);
		// System.out.println(todo);
		// }
		// catch(IOException e) {
			// System.out.println(e);
			// throw new java.io.UncheckedIOException(e);
		// }
		// ObjectMapper objectMapper = new ObjectMapper();
		// System.out.println("file");
		// System.out.println("objectMapper");
		try {
			todoList = objectMapper.readValue(file, type);
			System.out.println(todoList);
		} catch(JsonParseException | JsonMappingException ex) {
			System.err.println(ex);
		} catch(IOException ex) {
			System.err.println(ex);
		}
	}
}