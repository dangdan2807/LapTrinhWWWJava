package jdbc.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import jdbc.model.Department;
import jdbc.model.Student;

public class DepartmentDbUtil {
	private DataSource dataSource;

	public DepartmentDbUtil(DataSource dataSource) {
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
	
	public List<Department> getClasses() throws Exception {
		List<Department> dataList = new ArrayList<>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			String query = "select * from Department";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt("id");
				String departmentName = rs.getString("departmentName");
				Department tempStudent = new Department(id, departmentName);
				dataList.add(tempStudent);
			}
			return dataList;
		} finally {
			close(con, stmt, rs);
		}
	}
}
