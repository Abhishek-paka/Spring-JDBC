package com.example.SpringJDBC.repo;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.SpringJDBC.model.Student;

@Repository
public class StudentDAO { 

	private JdbcTemplate template;

	public JdbcTemplate getTemplate() {
		return template;
	}

	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public void save(Student student) {

		String query = "insert into Student (id, name, tech) values(?, ?, ?)";

		int rows = template.update(query, student.getId(), student.getName(), student.getTech());

		System.out.println(rows + " row/s Added");
	}

	public List<Student> findAll() {

		String sql = "select * from Student";

//		RowMapper<Student> mapper = new RowMapper<Student>() {
//
//			@Override
//			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
//				Student student = new Student();
//				
//				student.setId(rs.getInt(1));
//				student.setName(rs.getString(2));
//				student.setTech(rs.getString(3));
//				
//				return student;
//			}
//		};
//		
//		List<Student> result = template.query(sql, mapper);

		List<Student> result = template.query(sql, (ResultSet rs, int rowNum) -> {

			Student student = new Student();

			student.setId(rs.getInt(1));
			student.setName(rs.getString(2));
			student.setTech(rs.getString(3));
			return student;

		});

		return result;
	}

}
