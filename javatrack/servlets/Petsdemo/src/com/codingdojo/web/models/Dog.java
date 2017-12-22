package com.codingdojo.web.models;

public class Dog extends Animal implements Pet{

	public Dog(String name,String breed, double weight) {
		this.name = name;
		this.breed = breed;
		this.weight = weight;
		
		
		}
	

	@Override
	public String showAffection() {
		// TODO Auto-generated method stub
		if(this.weight < 30) {
			return "Hopped on your lap";
		} else {
			return "curled up at your feet";
		}
	}
}
