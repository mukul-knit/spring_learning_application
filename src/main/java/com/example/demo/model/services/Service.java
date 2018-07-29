package com.example.demo.model.services;

import java.util.Collection;

public interface Service<T> {
	
	public Collection<T> getAll();
	
	public T get(final String id);
	
	public void add(final T t);
	
}
