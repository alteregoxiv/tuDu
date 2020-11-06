package org.tudu.app;

/**
 * Class for reading html files to a String.
 *
 */

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;

public class HtmlReader {

	private static String BASEDIR = System.getenv("DIR");

	public String readHTML(String fileName) throws FileNotFoundException, IOException {
		File file = new File(BASEDIR + "/views/" + fileName);
		FileReader fr = new FileReader(file);
		BufferedReader in = new BufferedReader(fr);
		String html = new String();
		String s;
		while ((s = in.readLine()) != null)
			html += s;
		return html;
	}

}