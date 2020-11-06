package org.tudu.app;

/**
 * generates Html template of todos and adds to todo.html
 *
 */

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

class HtmlTemplate {

	private static String BASEDIR = System.getenv("DIR");
	String getHTML() throws IOException, FileNotFoundException {
		File file = new File(BASEDIR + "/todo.html");
		FileReader fr = new FileReader(file);
		BufferedReader in = new BufferedReader(fr);
		String html = new String();
		String s;
		while ((s = in.readLine()) != null)
			html += s;
		System.out.println(html);
		return html;
	}
}