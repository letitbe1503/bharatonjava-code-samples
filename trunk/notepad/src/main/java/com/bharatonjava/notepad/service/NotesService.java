package com.bharatonjava.notepad.service;

import java.util.List;

import com.bharatonjava.notepad.dao.INotesDao;
import com.bharatonjava.notepad.dao.NotesDao;
import com.bharatonjava.notepad.domain.Note;

public class NotesService {
	
	private INotesDao dao;
	
	public NotesService() {
		dao = new NotesDao();
		
	}
	
	public int createNote(Note note){
		int count = dao.createNote(note);
		return count ;
	}
	
	public List<Note> getAllNotes(){
		return dao.getAllNotes();
	}
	
	public Note getNoteById(int noteId){
		return dao.getNoteById(noteId);
	}
}
