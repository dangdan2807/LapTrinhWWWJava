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

public class ClassesDbUtil {
	private DataSource dataSource;

	public ClassesDbUtil(DataSource dataSource) {
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

	public List<Classes> getClassList() throws Exception {
		List<Classes> dataList = new ArrayList<>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String query = "select c.id as `classId`, c.className, c.departmentId, d.departmentName "
					+ "from Class c , Department d where c.departmentId = d.id";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt("classId");
				String className = rs.getString("className");
				int departmentId = rs.getInt("departmentId");
				String departmentName = rs.getString("departmentName");

				Department department = new Department(departmentId, departmentName);
				Classes tempClass = new Classes(id, className, department);
				dataList.add(tempClass);
			}
			return dataList;
		} finally {
			close(con, stmt, rs);
		}
	}
	
	public Classes getClassById(int classId) throws Exception {
		Classes result = new Classes();
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String query = "select c.id as `classId`, c.className, c.departmentId, d.departmentName "
					+ "from Class c , Department d where c.departmentId = d.id and c.id = ? LIMIT 1";
			stmt = con.prepareStatement(query);
			stmt.setInt(1, classId);
			rs = stmt.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("classId");
				String className = rs.getString("className");
				int departmentId = rs.getInt("departmentId");
				String departmentName = rs.getString("departmentName");

				Department department = new Department(departmentId, departmentName);
				result = new Classes(id, className, department);
			}
			return result;
		} finally {
			close(con, stmt, rs);
		}
	}
}
