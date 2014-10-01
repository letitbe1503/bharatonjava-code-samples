package com.bharatonjava.notepad.web;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bharatonjava.notepad.domain.Note;
import com.bharatonjava.notepad.service.NotesService;

@Path("notes")
public class NoteResource {

	private NotesService service;
	
	public NoteResource() {
		service = new NotesService();
	}
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Note> getAllNotes() {
		List<Note> n = new ArrayList<Note>();
//		n.add(new Note(1,"test note", new Date()));
		n = service.getAllNotes();
		return n;
	}
	
	@GET
	@Path("note/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Note getNoteById(@PathParam("id")int noteId){
		Note note = service.getNoteById(noteId);
		return note;
	}
}
