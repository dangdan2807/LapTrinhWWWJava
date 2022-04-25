package model;

import java.util.LinkedHashMap;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class StudentValid {
	@NotNull(message = "Tên không được để trống")
	@NotBlank(message = "Tên không được để trống")
	private String firstName;

	@NotNull(message = "Họ không được để trống")
	@NotBlank(message = "Họ không được để trống")
	private String lastName;

	private String country;

	@NotNull(message = "Số điện thoại không được để trống")
	@NotBlank(message = "Số điện thoại không được để trống")
	@Size(min = 10, max = 10, message = "Số điện thoại phải có 10 số")
	private String phone;

	@NotNull(message = "Tuổi không được để trống")
	private Integer yearOfBirth;

	@Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "chỉ nhận 5 ký tự hoặc số")
	private String postalCode;

//	@CourseCode(value = "TOP", message = "must start with TOP")
//	private String courseCode;

	private LinkedHashMap<String, String> countryOptions;

	public StudentValid() {
		countryOptions = new LinkedHashMap<>();
		countryOptions.put("Brazil", "Brazil");
		countryOptions.put("France", "France");
		countryOptions.put("Germany", "Germany");
		countryOptions.put("India", "India");
		countryOptions.put("United States", "United States");

	}

//	public String getCourseCode() {
//		return courseCode;
//	}
//
//	public void setCourseCode(String courseCode) {
//		this.courseCode = courseCode;
//	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public Integer getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(Integer yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public void setCountryOptions(LinkedHashMap<String, String> countryOptions) {
		this.countryOptions = countryOptions;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

}
