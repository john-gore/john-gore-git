package com.codingdojo.web.models;

public class Cat extends Animal implements Pet{

	public Cat(String name,String breed, double weight) {
		this.name = name;
		this.breed = breed;
		this.weight = weight;
	}
	

	@Override
	public String showAffection() {
		// TODO Auto-generated method stub
		return "looked at you with affection";
	}
}
