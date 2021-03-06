package com.codingdojo.javabelt2.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;





@Entity
@Table(name="posts")
public class Post {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Size(min=2, message="Post must be longer than 2 characters.")
	private String idea;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User createdByUser;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "users_likes", 
        joinColumns = @JoinColumn(name = "post_id"), 
        inverseJoinColumns = @JoinColumn(name = "user_id")
    )
	private List<User> userlikes;
	
	public Post () {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

	public String getIdea() {
		return idea;
	}

	public void setIdea(String idea) {
		this.idea = idea;
	}

	public User getCreatedByUser() {
		return createdByUser;
	}

	public void setCreatedByUser(User createdByUser) {
		this.createdByUser = createdByUser;
	}

	public List<User> getUserlikes() {
		return userlikes;
	}

	public void setUserlikes(List<User> userlikes) {
		this.userlikes = userlikes;
	}
	
	
}
