package com.example.demo.resources;

import java.io.IOException;
import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.example.demo.model.services.InMemoryRepository;
import com.example.demo.model.services.RestaurantServiceImpl;
import com.example.demo.model.services.Service;
import com.example.demo.model.entities.Restaurant;

@Path("/v1/restaurants")
public class RestaurantApp {


	private Service<Restaurant> restaurantService = new RestaurantServiceImpl(new InMemoryRepository());
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response getAllrestaurants() {
		Collection<Restaurant> restaurants = this.restaurantService.getAll();
		if(restaurants == null) {
	        return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for restaurants ").build();
	    }
		ObjectMapper objmapper = new ObjectMapper();
	    String json;
		try {
			json = objmapper.writeValueAsString(restaurants);
			return Response.ok(json, MediaType.APPLICATION_JSON).build();
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path(value = "/{restaurant_id}")
	public Response getRestaurant(@PathParam("restaurantId") String restaurantId) {
		Restaurant restaurant = this.restaurantService.get(restaurantId);
		if(restaurant == null) {
	        return Response.status(Response.Status.NOT_FOUND).entity("Entity not found for restaurantId: " + restaurantId).build();
	    }
		ObjectMapper objmapper = new ObjectMapper();
	    String json;
		try {
			json = objmapper.writeValueAsString(restaurant);
			 return Response.ok(json, MediaType.APPLICATION_JSON).build();
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	   
	}

}
