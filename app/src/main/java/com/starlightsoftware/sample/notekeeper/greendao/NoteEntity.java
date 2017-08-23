package com.starlightsoftware.sample.notekeeper.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

@Entity(indexes = {
				@Index(value = "text, date DESC", unique = true)
})

public class NoteEntity {

		@Id
		private Long id;

		@Index(unique = true)
		private String key;

		@NotNull
		private String text;
		private Long date;
		@Generated(hash = 1948125927)
		public NoteEntity(Long id, String key, @NotNull String text, Long date) {
			this.id = id;
			this.key = key;
			this.text = text;
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
		public String getText() {
			return this.text;
		}
		public void setText(String text) {
			this.text = text;
		}
		public Long getDate() {
			return this.date;
		}
		public void setDate(Long date) {
			this.date = date;
		}
}
