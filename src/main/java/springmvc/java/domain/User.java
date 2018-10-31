package springmvc.java.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "user")
public class User {

	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	
	@Column(name = "userId" , nullable = false)
	@NotEmpty(message = "userId should not be Empty")
	@Size(min= 8 ,max = 12 )
	private String userId;

	@Column(name = "firstName" , nullable = false)
	@NotEmpty(message = "firstName should not be Empty")
	@Size(min = 3 , max = 20 )
	private String firstName;
	
	@Size(min = 3 , max = 20)
	@NotEmpty(message = "lastName should not be Empty")
	@Column(name = "lastName" , nullable = false)
	private String lastName;
	
	@Size(min = 8 , max =15 )
	@NotEmpty(message = "password should not be Empty")
	@Column(name = "password" , nullable = false)
	private String password;
	
	@Pattern(regexp = "[0-9]+" , message ="Only Numerics" )
	@NotEmpty(message = "Phone Number should not be Empty")
	@Size(min = 10, max =10)
	@Column(name = "phoneNumber" , nullable = false)
	private String phoneNumber;
	
	@NotEmpty(message = "Email should not be Empty")
	@Email(message = "Not a valid Email")
	@Column(name = "email" , nullable = false)
	private String email;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", password="
				+ password + ", phoneNumber=" + phoneNumber + ", email=" + email + "]";
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
