package springDemo.entity;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	// @NotBlank(message = "Tên không được để trống")
	// @NotNull(message = "Tên không được để trống")
	// @Size(min = 2, message = "Tên ít nhất phải có 2 ký tự")
	@Column(name = "first_name")
	private String firstName;

	// @NotBlank(message = "Họ không được để trống")
	// @NotNull(message = "Họ không được để trống")
	// @Size(min = 2, message = "Họ ít nhất phải có 2 ký tự")
	@Column(name = "last_name")
	private String lastName;

	// @Pattern(regexp = "^[a-zA-Z0-9._+]+@[a-zA-Z0-9.]+$", message = "Email không hợp lệ")
	// @NotNull(message = "Email không được để trống")
	@Column(name = "email")
	private String email;

	public Customer() {
	}

	public Customer(int id) {
		super();
		this.id = id;
	}

	public Customer(@NotBlank(message = "Tên không được để trống") String firstName,
			@NotBlank(message = "Họ không được để trống") String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Customer(int id, @NotBlank(message = "Tên không được để trống") String firstName,
			@NotBlank(message = "Họ không được để trống") String lastName, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
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

}
