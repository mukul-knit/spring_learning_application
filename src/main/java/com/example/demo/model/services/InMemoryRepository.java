package com.example.demo.model.services;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import com.example.demo.model.entities.Restaurant;

public class InMemoryRepository implements Repository<Restaurant> {
	
	private final ConcurrentMap<String, Restaurant> inMemCache = new ConcurrentHashMap<>();
	
	public InMemoryRepository() {
		 	Restaurant restaurant1 = new Restaurant("rest1", "China town", "Cannaught Place","DELHI", "125/B");
	        Restaurant restaurant2 = new Restaurant("rest2", "Beer Yaani", "SDA","DELHI", "SDA Market");
	        Restaurant restaurant3 = new Restaurant("rest3", "Molecule", "Sector 29","Gurgaon", "29");
	        this.inMemCache.putIfAbsent(restaurant1.getId(), restaurant1);
	        this.inMemCache.putIfAbsent(restaurant2.getId(), restaurant2);
	        this.inMemCache.putIfAbsent(restaurant3.getId(), restaurant3);
	}

	@Override
	public Collection<Restaurant> getAllFromRepo() {
		return this.inMemCache.values();
	}

	@Override
	public synchronized void addToRepo(Restaurant t) {
			this.inMemCache.putIfAbsent(t.getId(), t);
	}

	@Override
	public Restaurant getFromRepo(String id) {
		return this.inMemCache.get(id);

	}
}
