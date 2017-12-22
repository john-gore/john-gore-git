package com.codingdojo.poolrental.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

import com.kenny.springevents.models.Role;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Size(min=1, message="First name cannot be blank")
	private String FirstName;
	
	@Size(min=1, message="First name cannot be blank")
	private String LastName;
	
	@Email
	@Column(unique=true)
	private String email;
	
	@Size(min=4, message = "Password must be at least 4")
	private String password;
	
	@Transient
	private String passwordConfirmation;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinTable(
		name = "users_roles",
		joinColumns = @JoinColumn(name="user_id"),
		inverseJoinColumns = @JoinColumn(name= "role_id"))
	
	private List<Role> roles;
	
	
	
	
	
}
