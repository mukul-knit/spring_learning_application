package com.example.demo.model.services;

import java.util.Collection;

import com.example.demo.model.entities.Restaurant;

public abstract class ServiceImpl<T> implements Service<T> {
	
	public Repository<T> restaurantCache;
	
	public ServiceImpl(Repository<T> restaurantCache) {
		super();
		this.restaurantCache = restaurantCache;
	}
	
	@Override
	public Collection<T> getAll() {
		return this.restaurantCache.getAllFromRepo();
	}

	@Override
	public T get(String id) {
		return this.restaurantCache.getFromRepo(id);
	}

	@Override
	public void add(T t) {
		this.restaurantCache.addToRepo(t);
	}
	
}
