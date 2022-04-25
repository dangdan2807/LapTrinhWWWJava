package jdbc.model;

public class Student {
	private int id;
	private String firstName;
	private String lastName;
	private boolean gender;
	private String email;
	private String imageUrl;
	private Classes classes;

	public Student(int id, String firstName, String lastName, boolean gender, String email, String imageUrl, Classes classes) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.imageUrl = imageUrl;
		this.classes = classes;
	}

	public Student(String firstName, String lastName, boolean gender, String email, String imageUrl, Classes classes) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.imageUrl = imageUrl;
		this.classes = classes;
	}
	
	public Student() {
	}
	
	

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public boolean getGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", email=" + email + ", imageUrl=" + imageUrl + ", classes=" + classes + "]";
	}

}
