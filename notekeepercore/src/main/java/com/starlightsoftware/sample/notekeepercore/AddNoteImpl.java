package com.starlightsoftware.sample.notekeepercore;

public class AddNoteImpl implements AddNote {

		private AddNotePresenter presenter;
		private NoteGateway noteGateway;

		public AddNoteImpl(AddNotePresenter presenter, NoteGateway noteGateway) {
				this.presenter = presenter;
				this.noteGateway = noteGateway;
		}

		@Override
		public void addNote(AddNoteRequest request) {
				noteGateway.putNote(new Note(request.getTitle(), request.getContent()));
				presenter.present(AddNoteResult.SUCCESS);
		}
}
