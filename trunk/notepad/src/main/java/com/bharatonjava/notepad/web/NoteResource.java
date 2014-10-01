package com.bharatonjava.notepad.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.bharatonjava.notepad.domain.Note;

@Path("notes")
public class NoteResource {

	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Note> getAllNotes() {
		List<Note> n = new ArrayList<Note>();
		n.add(new Note(1,"test note", new Date()));
		return n;
	}
}
