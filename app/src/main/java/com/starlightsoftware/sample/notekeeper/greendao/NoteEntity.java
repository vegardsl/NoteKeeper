package com.starlightsoftware.sample.notekeeper.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

@Entity(indexes = {
				@Index(value = "title, date DESC", unique = true)
})

public class NoteEntity {

		@Id
		private Long id;

		@Index(unique = true)
		private String key;

		@NotNull
		private String title;
		private String content;
		private Long date;
		@Generated(hash = 1013106188)
		public NoteEntity(Long id, String key, @NotNull String title, String content,
				Long date) {
			this.id = id;
			this.key = key;
			this.title = title;
			this.content = content;
			this.date = date;
		}
		@Generated(hash = 734234824)
		public NoteEntity() {
		}
		public Long getId() {
			return this.id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getKey() {
			return this.key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public String getTitle() {
			return this.title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getContent() {
			return this.content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public Long getDate() {
			return this.date;
		}
		public void setDate(Long date) {
			this.date = date;
		}
}
