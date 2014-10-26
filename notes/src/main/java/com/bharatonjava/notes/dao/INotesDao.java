package com.bharatonjava.notes.dao;

import java.util.List;

import com.bharatonjava.notes.domain.Note;

public interface INotesDao {

	public List<Note> getAllNotes();
}
