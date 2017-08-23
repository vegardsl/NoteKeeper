package com.starlightsoftware.sample.notekeepercore;

import org.junit.Test;

import java.util.Calendar;
import java.util.StringTokenizer;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class NoteTest {
		@Test
		public void canCreate_normalArgs() {
				String noteId = "10";
				String title = "title";
				String content = "content";
				Note note = new Note(title, content);

				assertNotNull(note);
				assertEquals(title, note.getTitle());
				assertEquals(content, note.getContent());
		}

		@Test
		public void canCreate_nullText() {
				String noteId = "10";

				long date = Calendar.getInstance().getTimeInMillis();
				Note note = new Note(null, null);

				assertNotNull(note);
				assertEquals("", note.getContent());
				assertEquals(date, note.getDate());
		}
}
