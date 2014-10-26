package com.bharatonjava.notes.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bharatonjava.notes.dao.INotesDao;
import com.bharatonjava.notes.domain.Note;

@Service
public class NotesService {

	private INotesDao notesDao;
	
	public void setNotesDao(INotesDao notesDao) {
		this.notesDao = notesDao;
	}
	
	@Transactional
	public List<Note> getAllNotes() {
		return notesDao.getAllNotes();
	}
}
