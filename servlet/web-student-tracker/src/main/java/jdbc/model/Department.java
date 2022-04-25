package jdbc.model;

public class Department {
	private int departmentId;
	private String departmentName;

	public Department(int departmentId, String departmentName) {
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}

	public Department() {
		this.departmentId = -1;
		this.departmentName = "";
	}

	public final int getDepartmentId() {
		return departmentId;
	}

	public final void setDepartmentId(int id) {
		this.departmentId = id;
	}

	public final String getDepartmentName() {
		return departmentName;
	}

	public final void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "Department [id=" + departmentId + ", departmentName=" + departmentName + "]";
	}

}
