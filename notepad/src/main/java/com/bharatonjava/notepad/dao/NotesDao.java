package com.bharatonjava.notepad.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bharatonjava.notepad.domain.Note;
import com.bharatonjava.notepad.utils.DbUtils;

public class NotesDao implements INotesDao{

	private static final Logger log = LoggerFactory.getLogger(NotesDao.class);
	
	
	@Override
	public List<Note> getAllNotes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Note> getNotesByDate(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Note getNoteById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteNote(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateNote(Note note) {
		String sql  = "UPDATE NOTES SET CONTENT =?, UPDATED_DATE = ? WHERE NOTE_ID=?";
		
		PreparedStatement stmt = null;
		try {
			stmt = DbUtils.getConnection().prepareStatement(sql);
			stmt.setString(1, note.getContent());
			stmt.setTimestamp(2, new java.sql.Timestamp(new Date().getTime()));
			stmt.setInt(3, note.getNoteId());
			
			int status = stmt.executeUpdate();
			log.info("Note updated. Status: "+ status);
			
		} catch (SQLException e) {

			log.error("exception while updating Note",e);
		}
		
	}

	@Override
	public void createNote(Note note) {
		
		
	}

}
