package com.codingdojo.javabelt1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.javabelt1.models.Subscription;


@Repository
public interface SubscriptionRepository extends CrudRepository<Subscription, Long>{
	List<Subscription> findAll();
	Subscription findOne(Long id);
	
	@Query(value = "SELECT * FROM subscriptions WHERE available = 1", nativeQuery=true)
    List<Subscription> findActivated();
}
