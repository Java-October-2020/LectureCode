package com.matthew.products.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	@NotBlank(message="Name must not be blank")
	private String firstName;
	@NotBlank(message="Name must not be blank")
	private String lastName;
	@NotBlank(message="Email must not be blank")
	@Email(message="Email must be valid")
    private String email;
	@Size(min=8, message="Password must be greater than 8 characters")
    private String password;
    @Transient
    private String confirmPassword;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;
    @OneToMany(mappedBy="user", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    private List<Rating> ratings;
    @OneToMany(mappedBy="creator", fetch=FetchType.LAZY)
    private List<Product> products;
	public User() {
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
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
