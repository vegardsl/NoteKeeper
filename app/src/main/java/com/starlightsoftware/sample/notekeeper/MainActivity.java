package com.starlightsoftware.sample.notekeeper;

import android.os.NetworkOnMainThreadException;
import android.support.constraint.solver.ArrayLinkedVariables;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.starlightsoftware.sample.notekeeper.greendao.DaoSession;
import com.starlightsoftware.sample.notekeeper.greendao.LocalRepoApi;
import com.starlightsoftware.sample.notekeeper.greendao.NoteEntity;
import com.starlightsoftware.sample.notekeeper.greendao.NoteEntityDao;
import com.starlightsoftware.sample.notekeepercore.AddNote;
import com.starlightsoftware.sample.notekeepercore.AddNoteImpl;
import com.starlightsoftware.sample.notekeepercore.AddNotePresenter;
import com.starlightsoftware.sample.notekeepercore.AddNoteRequest;
import com.starlightsoftware.sample.notekeepercore.AddNoteResult;
import com.starlightsoftware.sample.notekeepercore.Note;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AddNotePresenter{

		private NoteEntityDao noteDao;
		private AddNote addNote;
		private LocalRepoApi localRepoApi;

		private TextView notesTextView;

		@Override
		protected void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
				setContentView(R.layout.activity_main);

				notesTextView = (TextView) findViewById(R.id.notes_text_view);

				localRepoApi = new LocalRepoApi((App) getApplication());

				refreshView();

				addNote = new AddNoteImpl(this, localRepoApi = new LocalRepoApi((App) getApplication())
				);
		}

		private void refreshView() {
				ArrayList<Note> notes = localRepoApi.getAll();

				notesTextView.setText("");
				for (Note note : notes) {
						notesTextView.setText(notesTextView.getText() + "\n" + note.getTitle());
				}
		}

		@Override
		public void present(AddNoteResult result) {
				if (result.equals(AddNoteResult.SUCCESS))
						refreshView();
		}

		public void onClickAdd(View view) {
				addNote.addNote(new AddNoteRequest("Title", "Content"));
		}
}
