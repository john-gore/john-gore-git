package com.codingdojo.javabelt1.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="subscriptions")
public class Subscription {
	
		@Id
		@GeneratedValue
		private long id;
		
		@Size(min=1, message="Subsciption name cannot be blank.")
		private String subscriptionName;
		
		@Column
	    @Min(1)
		private Double cost;
		
		@Future(message="Subcription must be in the future.")
		@DateTimeFormat(pattern = "yyyy-MM-dd")
		private Date startDate;
		
		
		@OneToMany(mappedBy="subscription", fetch = FetchType.LAZY)
	    private List<User> users;
		
		private Boolean available;
		
		private Date createdAt;
		private Date updatedAt;
		
		public Subscription () {
			
		}
		
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

		

		public String getSubscriptionName() {
			return subscriptionName;
		}

		public void setSubscriptionName(String subscriptionName) {
			this.subscriptionName = subscriptionName;
		}

		public Double getCost() {
			return cost;
		}

		public Date getStartDate() {
			return startDate;
		}

		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}

		public void setCost(Double cost) {
			this.cost = cost;
		}


		public List<User> getUsers() {
			return users;
		}

		public void setUsers(List<User> users) {
			this.users = users;
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

		public Boolean getAvailable() {
			return available;
		}

		public void setAvailable(Boolean available) {
			this.available = available;
		}

	    
}
