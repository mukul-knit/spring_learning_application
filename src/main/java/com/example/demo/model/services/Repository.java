package com.example.demo.model.services;

import java.util.Collection;

public interface Repository<T> {
	
	public Collection<T> getAllFromRepo();

	public void addToRepo(T t);
	
	public T getFromRepo(final String id);
}
