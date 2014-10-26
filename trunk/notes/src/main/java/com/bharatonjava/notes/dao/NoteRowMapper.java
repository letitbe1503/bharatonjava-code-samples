package com.bharatonjava.notes.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.bharatonjava.notes.domain.Note;

public class NoteRowMapper implements RowMapper<Note> {

	@Override
	public Note mapRow(ResultSet rs, int rowNum) throws SQLException {
		Note n = new Note();
		n.setNoteId(rs.getLong("Note_id"));
		n.setTitle(rs.getString("title"));
		n.setNoteText(rs.getString("note_text"));
		return n;
	}
}
