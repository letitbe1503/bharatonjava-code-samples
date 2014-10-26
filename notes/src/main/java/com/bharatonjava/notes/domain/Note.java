package com.bharatonjava.notes.domain;

import java.util.Date;

public class Note {

	private Long noteId;
	private String title;
	private String noteText;
	private Date createdDate;
	private Date updatedDate;

	public Note() {
	}

	public Note(String title, String noteText) {
		super();
		this.title = title;
		this.noteText = noteText;
	}

	public Long getNoteId() {
		return noteId;
	}

	public void setNoteId(Long noteId) {
		this.noteId = noteId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNoteText() {
		return noteText;
	}

	public void setNoteText(String noteText) {
		this.noteText = noteText;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "Note [noteId=" + noteId + ", title=" + title + ", noteText="
				+ noteText + ", createdDate=" + createdDate + ", updatedDate="
				+ updatedDate + "]";
	}

	
	
}
