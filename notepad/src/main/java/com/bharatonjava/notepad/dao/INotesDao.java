package com.bharatonjava.notepad.dao;

import java.util.Date;
import java.util.List;

import com.bharatonjava.notepad.domain.Note;

public interface INotesDao {

	public List<Note> getAllNotes();
	
	public List<Note> getNotesByDate(Date date);
	
	public Note getNoteById();
	
	public void deleteNote(int id);
	
	public void updateNote(Note note);
	
	public void createNote(Note note);
}
