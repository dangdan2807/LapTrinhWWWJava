package iuh.fit.src;

public class Student {
	private String firstName;
	private String lastName;
	private boolean gender;
	public synchronized String getFirstName() {
		return firstName;
	}
	public synchronized void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public synchronized String getLastName() {
		return lastName;
	}
	public synchronized void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public synchronized boolean isGender() {
		return gender;
	}
	public synchronized void setGender(boolean gender) {
		this.gender = gender;
	}
	public Student(String firstName, String lastName, boolean gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
	}
	public Student() {
		super();
	}
	
	
}
