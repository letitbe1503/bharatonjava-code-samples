package com.bharatonjava.notepad.domain;

import java.util.Date;

public class Note {
	private int noteId;
	private String content;
	private Date noteDate;

	public Note() {
	}

	public Note(int noteId, String content, Date noteDate) {
		super();
		this.noteId = noteId;
		this.content = content;
		this.noteDate = noteDate;
	}

	public int getNoteId() {
		return noteId;
	}

	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getNoteDate() {
		return noteDate;
	}

	public void setNoteDate(Date noteDate) {
		this.noteDate = noteDate;
	}

	@Override
	public String toString() {
		return "Note [noteId=" + noteId + ", content=" + content
				+ ", noteDate=" + noteDate + "]";
	}

}
