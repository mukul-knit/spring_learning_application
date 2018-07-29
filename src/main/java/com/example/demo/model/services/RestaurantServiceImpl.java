package com.example.demo.model.services;

import com.example.demo.model.entities.Restaurant;

public class RestaurantServiceImpl extends ServiceImpl<Restaurant> {

	public RestaurantServiceImpl(Repository<Restaurant> restaurantCache) {
		super(restaurantCache);
	}
	
	public void addRestaurant(Restaurant restaurant) {
		this.restaurantCache.addToRepo(restaurant);
	}

}
