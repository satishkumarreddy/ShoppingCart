package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.model.CartItem;
public interface CartDAO 
{
	public void add(CartItem cartItem);
	public CartItem get(int id);
	public List getAllItems();
	public void remove(int id);
	public void removeAll();
	public void update(int cartItemId,int quantity);
	
}
