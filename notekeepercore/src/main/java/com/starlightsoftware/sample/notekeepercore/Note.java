package com.starlightsoftware.sample.notekeepercore;

import java.util.Calendar;

public class Note {

		private String content;
		private long date;
		private String title;
		private String id;

		public Note(String title, String content, long date, String id) {
				this.date = date;
				this.id = id;
				initTitleAndContent(title, content);
		}

		public Note(String title, String content) {
				this.date = Calendar.getInstance().getTimeInMillis();
				initTitleAndContent(title, content);
				id = title + Long.toString(date);
		}

		private void initTitleAndContent(String title, String content) {
				this.title = title;
				this.content = content;

				if (title == null) title = "";
				if (content == null) content = "";
		}

		public String getId() {
				return id;
		}

		public String getTitle() {
				return title;
		}

		public String getContent() {
				return content;
		}

		public long getDate() {
				return date;
		}
}
