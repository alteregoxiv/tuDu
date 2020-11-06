package org.tudu.app;

/**
 * generates Html templates for rendering.
 *
 */

import java.io.IOException;

class HtmlTemplate {

	private static HtmlReader reader = new HtmlReader();

	String getHTML() throws IOException {
		String html = reader.readHTML("base.html");
		System.out.println(html);
		return html;
	}
}