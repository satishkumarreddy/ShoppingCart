package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.User;
import com.niit.shoppingcart.model.UserDetails;

public interface UserDAO {

	public List<UserDetails> list();
	
	
	public UserDetails get(int id);
	
	
	
	
	
	public void delete(int id);


	public void saveorUpdate(UserDetails registeruser);


	public void save(User loginuser);
	
	
}

