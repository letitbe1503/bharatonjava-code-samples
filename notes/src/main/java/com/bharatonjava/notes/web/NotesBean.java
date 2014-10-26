package com.bharatonjava.notes.web;

import java.util.List;

import javax.annotation.PostConstruct;

import com.bharatonjava.notes.domain.Note;
import com.bharatonjava.notes.services.NotesService;

public class NotesBean {
	
	private NotesService notesService;
	
	
	private List<Note> notes;
	
	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}
	
	public List<Note> getNotes() {
		return notes;
	}

	public void setNotesService(NotesService notesService) {
		this.notesService = notesService;
	}
	
	@PostConstruct
    public void init() {
		this.notes = this.notesService.getAllNotes();
	}
	
}
