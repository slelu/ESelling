package edu.mum.eselling.domain;

	import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;


	@MappedSuperclass
	@Inheritance(strategy=InheritanceType.JOINED)
	public class User implements Serializable{

	private static final long serialVersionUID = -3794885616176050983L;
	@Id
	@GeneratedValue
	private long id;
    @NotEmpty(message="{User.FirstName}")
	private String firstName;
    @NotEmpty(message="{User.LastName}")
	private String lastName;
    @NotEmpty(message="{User.Email}")
	private String email;
    @NotEmpty(message="{User.Phone}")
	private String phone;
    @NotEmpty(message="{User.Password}")
	private String password;
	
    @Valid
	@OneToOne(fetch=FetchType.LAZY) 
	@JoinColumn(name="USERNAME") 
	private Credentials credentials;
    @Valid
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Address address;
	

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Credentials getCredentials() {
		return credentials;
	}
	public void setCredentials(Credentials credentials) {
		this.credentials = credentials;
	}
	
	}
