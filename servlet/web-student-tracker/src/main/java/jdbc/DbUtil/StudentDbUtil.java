package jdbc.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import jdbc.model.Classes;
import jdbc.model.Department;
import jdbc.model.Student;

public class StudentDbUtil {
	private DataSource dataSource;

	public StudentDbUtil(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	private void close(Connection con, Statement stmt, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (con != null)
				con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Student> getStudentsByClassId(int classId) throws Exception {
		List<Student> dataList = new ArrayList<>();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String query = "select s.id as `studentId`, s.firstName, s.lastName, s.gender, s.email, s.imageUrl, "
					+ "s.classId, c.className, c.departmentId, d.departmentName "
					+ "from student s, class c, department d "
					+ "where s.classId = c.id and c.departmentId = d.id and c.id = ?";
			stmt = con.prepareStatement(query);
			stmt.setInt(1, classId);
			rs = stmt.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("studentId");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				boolean gender = rs.getBoolean("gender");
				String email = rs.getString("email");
				String imageUrl = rs.getString("imageUrl");

				int class_Id = rs.getInt("classId");
				String className = rs.getString("className");
				int departmentId = rs.getInt("departmentId");
				String departmentName = rs.getString("departmentName");

				Department department = new Department(departmentId, departmentName);
				Classes classes = new Classes(class_Id, className, department);
				Student tempStudent = new Student(id, firstName, lastName, gender, email, imageUrl, classes);
				dataList.add(tempStudent);
			}
			return dataList;
		} finally {
			close(con, stmt, rs);
		}
	}

	public void addStudent(Student student) throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = dataSource.getConnection();
			String query = "insert into student (firstName, lastName, gender, email, imageUrl, classId)"
					+ " values (?, ?, ?, ?, ?, ?)";
			stmt = con.prepareStatement(query);
			stmt.setString(1, student.getFirstName());
			stmt.setString(2, student.getLastName());
			stmt.setBoolean(3, student.getGender());
			stmt.setString(4, student.getEmail());
			stmt.setString(5, student.getImageUrl());
			stmt.setInt(6, student.getClasses().getClassId());
			stmt.execute();
		} finally {
			close(con, stmt, null);
		}
	}

	public void updateStudent(Student student) throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = dataSource.getConnection();
			String query = "update student set firstName=?, lastName=?, gender=?, email=?, imageUrl=?, classId=?"
					+ " where id=?";
			stmt = con.prepareStatement(query);
			stmt.setString(1, student.getFirstName());
			stmt.setString(2, student.getLastName());
			stmt.setBoolean(3, student.getGender());
			stmt.setString(4, student.getEmail());
			stmt.setString(5, student.getImageUrl());
			stmt.setInt(6, student.getClasses().getClassId());
			stmt.setInt(7, student.getId());
			stmt.execute();
		} finally {
			close(con, stmt, null);
		}
	}

	public void deleteStudent(String theStudentId) throws Exception {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			int studentId = Integer.parseInt(theStudentId);
			con = dataSource.getConnection();
			String query = "delete from student where id=?";
			stmt = con.prepareStatement(query);
			stmt.setInt(1, studentId);
			stmt.execute();
		} finally {
			close(con, stmt, null);
		}
	}

	public Student getStudent(String theStudentId) throws Exception {
		Student student = null;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int studentId;
		try {
			studentId = Integer.parseInt(theStudentId);
			con = dataSource.getConnection();
			String query = "select s.id as `studentId`, s.firstName, s.lastName, s.gender, s.email, s.imageUrl, "
					+ "s.classId, c.className, c.departmentId, d.departmentName "
					+ "from student s, class c, department d "
					+ "where s.classId = c.id and c.departmentId = d.id and s.id = ? LIMIT 1";
			stmt = con.prepareStatement(query);
			stmt.setInt(1, studentId);
			rs = stmt.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("studentId");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				boolean gender = rs.getBoolean("gender");
				String email = rs.getString("email");
				String imageUrl = rs.getString("imageUrl");

				int class_Id = rs.getInt("classId");
				String className = rs.getString("className");
				int departmentId = rs.getInt("departmentId");
				String departmentName = rs.getString("departmentName");

				Department department = new Department(departmentId, departmentName);
				Classes classes = new Classes(class_Id, className, department);
				student = new Student(id, firstName, lastName, gender, email, imageUrl, classes);
			} else {
				throw new Exception("Could not find student id: " + studentId);
			}
			return student;
		} finally {
			close(con, stmt, rs);
		}
	}
}
