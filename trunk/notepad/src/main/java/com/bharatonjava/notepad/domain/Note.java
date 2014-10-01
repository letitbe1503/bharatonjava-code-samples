package com.bharatonjava.notepad.domain;

import java.util.Date;

public class Note {
	private int noteId;
	private String content;
	private Date createdDate;
	private Date updatedDate;

	public Note() {
	}

	public Note(int noteId, String content, Date createdDate) {
		super();
		this.noteId = noteId;
		this.content = content;
		this.createdDate = createdDate;
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
		return "Note [noteId=" + noteId + ", content=" + content
				+ ", createdDate=" + createdDate + ", updatedDate="
				+ updatedDate + "]";
	}

}
