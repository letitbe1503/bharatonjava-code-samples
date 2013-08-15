package com.bharatonjava.school.dao;

import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bharatonjava.school.dao.mappers.StudentRowMapper;
import com.bharatonjava.school.domain.Student;

public class StudentDaoImpl implements StudentDao {

	private static final Log log = LogFactory.getLog(StudentDaoImpl.class);

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public StudentDaoImpl() {
	}

	@Override
	public int saveStudent(Student student) {
		String sql = "insert into student (first_name, middle_name,last_name,date_of_birth, grade_id)"
				+ " values(?,?,?,?,?)";
		int count = this.jdbcTemplate.update(
				sql,
				new Object[] { student.getFirstName(),
						student.getMiddleName(), student.getLastName(),
						student.getDob(), student.getGradeId() });
		return count;
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> students = null;
		String sql = "select * from student";
		students = this.jdbcTemplate.query(sql, new StudentRowMapper());
		log.info("Returning " + students != null ? students.size()
				: 0 + " Students");
		return students;
	}
	
	
	public Student getStudentById(Long studentId){
		
		Student s = null;
		String sql = "select * from student where student_id=?";
		s = (Student) this.jdbcTemplate.queryForObject(sql, new StudentRowMapper(), new Object[]{studentId});
		log.info(s);
		return s;
	}
	

}
