package jdbc.model;

public class Classes {
	private int classId;
	private String className;
	private Department department;

	public Classes(int classId, String className, Department department) {
		this.classId = classId;
		this.className = className;
		this.department = department;
	}

	public Classes(int classId) {
		this.classId = classId;
	}

	public Classes() {
		this.classId = -1;
		this.className = "";
		this.department = new Department();
	}

	public final int getClassId() {
		return classId;
	}

	public final void setClassId(int id) {
		this.classId = id;
	}

	public final String getClassName() {
		return className;
	}

	public final void setClassName(String className) {
		this.className = className;
	}

	public final Department getDepartment() {
		return department;
	}

	public final void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Classes [id=" + classId + ", className=" + className + ", department=" + department + "]";
	}

}
