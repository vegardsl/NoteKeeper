package com.starlightsoftware.sample.notekeeper.greendao;

import com.starlightsoftware.sample.notekeeper.App;
import com.starlightsoftware.sample.notekeepercore.Note;
import com.starlightsoftware.sample.notekeepercore.NoteGateway;

import java.util.ArrayList;
import java.util.List;

public class LocalRepoApi implements NoteGateway {

		private NoteEntityDao noteDao;

		public LocalRepoApi(App application) {
				DaoSession daoSession = application.getDaoSession();
				noteDao = daoSession.getNoteEntityDao();
		}

		@Override
		public void putNote(Note note) {
				NoteEntity noteEntity = new NoteEntity();
				noteEntity.setText(note.getContent());
				noteEntity.setDate(note.getDate());
				noteEntity.setKey(note.getId());
				noteDao.insert(noteEntity);
		}

		public ArrayList<Note> getAll() {
				List<NoteEntity> noteEntities = noteDao.queryBuilder().list();

				ArrayList<Note> notes = new ArrayList<>();
				for (NoteEntity noteEntity : noteEntities) {
						notes.add(new Note(noteEntity.getText(), noteEntity.getText()));
				}

				return notes;
		}

		public void removeAll() {
				noteDao.deleteAll();
		}
}
