package com.starlightsoftware.sample.notekeeper;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.starlightsoftware.sample.notekeeper.greendao.LocalRepoApi;
import com.starlightsoftware.sample.notekeepercore.AddNote;
import com.starlightsoftware.sample.notekeepercore.AddNoteImpl;
import com.starlightsoftware.sample.notekeepercore.AddNotePresenter;
import com.starlightsoftware.sample.notekeepercore.AddNoteRequest;
import com.starlightsoftware.sample.notekeepercore.AddNoteResult;
import com.starlightsoftware.sample.notekeepercore.Note;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AddNotePresenter {

		private AddNote addNote;
		private LocalRepoApi localRepoApi;

		private RecyclerView recyclerView;
		private NoteViewAdapter adapter;
		private RecyclerView.LayoutManager layoutManager;

		private ArrayList<Note> notes = new ArrayList<>();

		private String message = "Message \n";

		@Override
		protected void onCreate(Bundle savedInstanceState) {
				super.onCreate(savedInstanceState);
				setContentView(R.layout.activity_main);

				recyclerView = findViewById(R.id.note_recycler_view);
				recyclerView.setHasFixedSize(false);

				layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
				recyclerView.setLayoutManager(layoutManager);

				adapter = new NoteViewAdapter(notes);
				recyclerView.setAdapter(adapter);

				localRepoApi = new LocalRepoApi((App) getApplication());

				localRepoApi.removeAll();

				FloatingActionButton fab = findViewById(R.id.fab);
				fab.setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View view) {
								message = message + message;
								addNote.addNote(new AddNoteRequest("Title", message));
						}
				});

				refreshView();

				addNote = new AddNoteImpl(this, localRepoApi = new LocalRepoApi((App) getApplication())
				);
		}

		private void refreshView() {
				ArrayList<Note> notes = localRepoApi.getAll();
				adapter.setNotes(notes);
		}

		@Override
		public void present(AddNoteResult result) {
				if (result.equals(AddNoteResult.SUCCESS)) refreshView();
		}
}
