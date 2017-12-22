package com.kenny.springevents.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;



@Entity
@Table(name="users")
public class User {
	
	public User () {
		
	}
	
	@Id
	@GeneratedValue
	private long id;
	
	@Size(min=2, message="First Name must be longer than 2 characters.")
	private String firstName;
	
	@Size(min=2, message="Last Name must be longer than 2 characters.")
	private String lastName;
	
	@Email
	@Column(unique=true)
	private String email;
	
	@Size(min=1, message="City field cannot be blank")
	private String city;
	
	@Pattern(regexp="(?:(A[KLRZ]|C[AOT]|D[CE]|FL|GA|HI|I[ADLN]|K[SY]|LA|M[ADEINOST]|N[CDEHJMVY]|O[HKR]|P[AR]|RI|S[CD]|T[NX]|UT|V[AIT]|W[AIVY]))")
	private String state;
	
	@Size(min=4, message="Password must be at least 4 characters.")
	private String password;
	
	@Transient
	private String passwordConfirmation;
	
	private Date createdAt;
	
	private Date updatedAt;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name = "users_roles",
		joinColumns = @JoinColumn(name="user_id"),
		inverseJoinColumns = @JoinColumn(name= "role_id"))
	private List<Role> roles;
	
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "users_get_togethers", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "get_together_id")
    )
    private List<GetTogether> attendingGetTogethers;
    
    @OneToMany(mappedBy="poster", fetch=FetchType.LAZY)
    private List<Message> messages;
    
    @OneToMany(mappedBy="createdByUser", fetch=FetchType.LAZY)
    private List<GetTogether> createdGetTogethers;
    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}
	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
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
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public List<GetTogether> getAttendingGetTogethers() {
		return attendingGetTogethers;
	}
	public void setAttendingGetTogethers(List<GetTogether> attendingGetTogethers) {
		this.attendingGetTogethers = attendingGetTogethers;
	}
	public List<Message> getMessages() {
		return messages;
	}
	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	public List<GetTogether> getCreatedGetTogethers() {
		return createdGetTogethers;
	}
	public void setCreatedGetTogethers(List<GetTogether> createdGetTogethers) {
		this.createdGetTogethers = createdGetTogethers;
	}

    
	
}
