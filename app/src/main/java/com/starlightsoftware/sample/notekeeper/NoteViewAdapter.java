package com.starlightsoftware.sample.notekeeper;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.starlightsoftware.sample.notekeepercore.Note;

import java.util.ArrayList;

/**
	* Created by vegar on 8/23/2017.
	*/

class NoteViewAdapter extends RecyclerView.Adapter {

		private ArrayList<Note> notes;

		public NoteViewAdapter(ArrayList<Note> notes) {
				this.notes = notes;
		}

		void setNotes(ArrayList<Note> notes) {
				this.notes = notes;
				notifyDataSetChanged();
		}

		@Override
		public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
				View view = LayoutInflater.from(parent.getContext())
								.inflate(R.layout.note_thumbnail_layout, parent, false);

				return new ViewHolder(view);

		}

		@Override
		public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
				ViewHolder noteViewHolder = (ViewHolder) holder;
				noteViewHolder.titleTextView.setText(notes.get(position).getTitle());
				noteViewHolder.contentTextView.setText(notes.get(position).getContent());
		}

		@Override
		public int getItemCount() {
				return notes.size();
		}

		public static class ViewHolder extends RecyclerView.ViewHolder {
				TextView titleTextView;
				TextView contentTextView;

				public ViewHolder(View v) {
						super(v);
						titleTextView = v.findViewById(R.id.title_text);
						contentTextView = v.findViewById(R.id.content_text);
				}
		}

}
