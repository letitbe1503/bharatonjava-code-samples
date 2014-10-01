package com.bharatonjava.notepad.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bharatonjava.notepad.domain.Note;
import com.bharatonjava.notepad.utils.DbUtils;

public class NotesDao implements INotesDao {

	private static final Logger log = LoggerFactory.getLogger(NotesDao.class);

	@Override
	public List<Note> getAllNotes() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM NOTES";
		List<Note> notes = new ArrayList<Note>();

		try {
			conn = DbUtils.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Note n = new Note();
				n.setNoteId(rs.getInt("note_id"));
				n.setContent(rs.getString("content"));
				notes.add(n);
			}

		} catch (SQLException e) {
			log.error("", e);
		} catch (ClassNotFoundException e) {
			log.error("", e);
			e.printStackTrace();
		} finally {
			DbUtils.closeResources(rs, stmt, conn);
		}

		return notes;
	}

	@Override
	public List<Note> getNotesByDate(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Note getNoteById(int noteId) {
		log.info("NoteId: " + noteId);

		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM NOTES n where n.note_id = ?";
		Note note = new Note();

		try {
			conn = DbUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, noteId);
			rs = stmt.executeQuery();

			if(rs.next()) {

				note.setNoteId(rs.getInt("note_id"));
				note.setContent(rs.getString("content"));

			}

		} catch (SQLException e) {
			log.error("", e);
		} catch (ClassNotFoundException e) {
			log.error("", e);
			e.printStackTrace();
		} finally {
			DbUtils.closeResources(rs, stmt, conn);
		}

		return note;
	}

	@Override
	public void deleteNote(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateNote(Note note) {
		String sql = "UPDATE NOTES SET CONTENT =?, UPDATED_DATE = ? WHERE NOTE_ID=?";

		PreparedStatement stmt = null;
		try {
			stmt = DbUtils.getConnection().prepareStatement(sql);
			stmt.setString(1, note.getContent());
			stmt.setTimestamp(2, new java.sql.Timestamp(new Date().getTime()));
			stmt.setInt(3, note.getNoteId());

			int status = stmt.executeUpdate();
			log.info("Note updated. Status: " + status);

		} catch (SQLException e) {

			log.error("exception while updating Note", e);
		} catch (ClassNotFoundException e) {
			log.error("exception while updating Note", e);
		}

	}

	@Override
	public int createNote(Note note) {

		int count = 0;
		String sql = "insert into notes (content, created_date)values(?,?)";

		Connection conn = null;
		PreparedStatement stmt = null;
		try {

			conn = DbUtils.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, note.getContent());
			stmt.setTimestamp(2, new java.sql.Timestamp(new Date().getTime()));
			count = stmt.executeUpdate();
			log.info(count + " note inserted in database.");
		} catch (SQLException e) {
			log.error("", e);
		} catch (ClassNotFoundException e) {
			log.error("", e);
		} finally {
			DbUtils.closeResources(null, stmt, conn);
		}
		return count;
	}
}
