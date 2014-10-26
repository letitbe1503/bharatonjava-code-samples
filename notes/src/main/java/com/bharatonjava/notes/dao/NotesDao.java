package com.bharatonjava.notes.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.bharatonjava.notes.domain.Note;

public class NotesDao implements INotesDao {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Note> getAllNotes() {
		List<Note> notes = null;
		String sql = "select * from notes";
		notes = (List<Note>)this.jdbcTemplate.query(sql, new NoteRowMapper());
		return notes;
	}

}
