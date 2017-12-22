package com.codingdojo.poolrental.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name="reviews")
public class Review {
	@Id
    @GeneratedValue
    private Long id;
	
	@Size(min=1, message="Review cannot be blank")
	private String review;
	
	@Min(1)
	@Size(min=1, message="Rating must be 1 or more")
	private String rating;
}
