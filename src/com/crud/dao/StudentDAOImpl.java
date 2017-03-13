package com.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.crud.model.Student;
import com.crud.util.DBUtil;

public class StudentDAOImpl implements StudentDAO {
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	int result = 0;
	
	public StudentDAOImpl() {
		conn = DBUtil.getConnection();
	}

	@Override
	public int addStudent(Student student) {
		// TODO Auto-generated method stub
		String sql = "Insert into student(firstName,lastName,course,year) values (?,?,?,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,student.getFirstName());
			ps.setString(2,student.getLastName());
			ps.setString(3,student.getCourse());
			ps.setInt(4,student.getYear());
			result = ps.executeUpdate();
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteStudent(int studentId) {
		// TODO Auto-generated method stub
		String sql = "Delete from student where studentId = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1,studentId);
			result = ps.executeUpdate();
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateStudent(Student student) {
		String sql = "update table studnet set firstName=?,lastName=?,course=?,year=? where studentId=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,student.getFirstName());
			ps.setString(2,student.getLastName());
			ps.setString(3,student.getCourse());
			ps.setInt(4,student.getYear());
			ps.setInt(5,student.getStudentId());
			result = ps.executeUpdate();
			return result;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> students = new ArrayList<>();
		String sql = "select * from student";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Student student = new Student();
				student.setStudentId(rs.getInt("studentID"));
				student.setFirstName(rs.getString("firstName"));
				student.setLastName(rs.getString("lastName"));
				student.setCourse(rs.getString("course"));
				student.setYear(rs.getInt("year"));
				students.add(student);
			}
			return students;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Student getStudentById(int studentId) {
		String sql = "select * from student where studentId=?";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			Student student = new Student();
			student.setStudentId(rs.getInt("studentID"));
			student.setFirstName(rs.getString("firstName"));
			student.setLastName(rs.getString("lastName"));
			student.setCourse(rs.getString("course"));
			student.setYear(rs.getInt("year"));
			return student;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
