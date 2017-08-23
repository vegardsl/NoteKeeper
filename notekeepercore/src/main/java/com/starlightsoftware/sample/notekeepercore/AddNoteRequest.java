package com.starlightsoftware.sample.notekeepercore;

public class AddNoteRequest {

		private String title;
		private String content;

		public AddNoteRequest(String title, String content) {
				this.title = title;
				this.content = content;
		}

		String getTitle() {
				return title;
		}

		String getContent() {
				return content;
		}
}
