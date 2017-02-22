package com.niit.shoppingcart.controller;

import java.io.Serializable;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.google.gson.Gson;
import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.model.CartItem;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.User;

@Controller

public class CartController 
{
	@Autowired
	ProductDAO bsss;
	@Autowired
	CartDAO cd1;
	@Autowired
	UserDAO ua;
	@Autowired
	SessionFactory sf;
		
	   @ModelAttribute("cartItem")
	    public CartItem fun100()
	    {
	    	return new CartItem();
	    }
	
	 @RequestMapping(value="viewcart",method=RequestMethod.GET)
		public String vcHello(@RequestParam("id") int productId,HttpSession session)
		{  
		 String name=(String)session.getAttribute("loggedInUser");
		 Session s1=sf.openSession();
		 Transaction t=s1.beginTransaction();
		 Query q=s1.createQuery("from User where username='"+name+"'");
	     List<User> li=q.list();
	      User count1=li.get(0);
	     User user=(User)s1.get(User.class,count1.getId());
		 
	    Product product=bsss.getSingleProduct(productId);
	    CartItem cartItem=new CartItem();
	    // cart.setGrandTotal(product.getproductPrice());
	   
	   	List list=cd1.getAllItems();
	   	
	   	for(int i=0;list.size()>i;i++)
	   	{
	   	  CartItem cti=(CartItem)list.get(i);
	   	  if(productId==cti.getProductId())
	   	  {
	   		 
	   		  
	    cartItem.setProductId(product.getId());
	    cartItem.setProductName(product.getName());
	    cartItem.setProductPrice(product.getPrice());
	    cartItem.setProductDesc(product.getDescription());
	  
	   cartItem.setQuantity(cartItem.getQuantity()+1+cti.getQuantity());
	 
	    cartItem.setProductPrice(product.getPrice()*cartItem.getQuantity());
	    
	    cd1.add(cartItem);
        int count=cartItem.getCartItemId();
        cd1.remove(--count);
       
	    
	    return "viewCart";
	   	}
	   	}
	 
	   	cartItem.setProductId(product.getId());
	    cartItem.setProductName(product.getName());
	    cartItem.setProductPrice(product.getPrice());
	    cartItem.setProductDesc(product.getDescription());
	   
	    cartItem.setQuantity(cartItem.getQuantity()+1);
	  
	    cartItem.setProductPrice(product.getPrice()*cartItem.getQuantity());
	   
	    cd1.add(cartItem);    
		  
	    return "viewCart";
	    }
		  
	 @RequestMapping(value="/listone",method=RequestMethod.GET,produces="application/json")
	    public @ResponseBody String showListOne(){
	    	List blist=cd1.getAllItems();
	    	Gson x=new Gson();
	    	String json=x.toJson(blist);
	    	return json;
	    }
	 @RequestMapping("/deleteItemCart")
	    public ModelAndView deleteChair(@RequestParam int id)
	    {
		
         cd1.remove(id);
	    	return new ModelAndView("viewCart");
	    }
	 @RequestMapping("/removeAll")
	 public ModelAndView removeAllItem()
	 {
		 cd1.removeAll();
		 return new ModelAndView("viewCart");
	 }
	 @RequestMapping("/alert")
	 public ModelAndView dis()
	 {
		  return new ModelAndView("alert");
	 }
	 @RequestMapping("/v1")
	 public ModelAndView disp()
	 {
		  return new ModelAndView("ViewPro");
	 }
	 @RequestMapping(value="checkout")
	    public String createOrder(HttpSession session,Model m1)
		{
		 String name=(String)session.getAttribute("loggedInUser");
		 Session s1=sf.openSession();
		 Transaction t=s1.beginTransaction();
		 Query q=s1.createQuery("from User where username='"+name+"'");
	     List<User> li=q.list();
	      User count=li.get(0);
	     User user=(User)s1.get(User.class,count.getId());
		 
		 m1.addAttribute("user1",new User());
		 
		 //ModelAndView m3=new ModelAndView("collectCustomerInfo","User",user);
		 m1.addAttribute("User",user);
		 return "redirect:/collectCustomerInfo";
			
	    }
	 @RequestMapping(value="collectCustomerInfo",method=RequestMethod.GET)
	    public ModelAndView fun1001()
	    {
	    	return new ModelAndView ("collectCustomerInfo");
	    }
	 @ModelAttribute("User")
	    public User fun1002()
	    {
	    	return new User();
	    }
	 @RequestMapping(value="orderConfirmation",method=RequestMethod.GET)
	    public ModelAndView fun1009()
	    {
	    	return new ModelAndView ("orderConfirmation");
	    }
	 @RequestMapping(value="hellohi")
	 public ModelAndView fun1003(HttpSession session,Model m1)
	 {
		 String name=(String)session.getAttribute("loggedInUser");
		 Session s1=sf.openSession();
		 Transaction t=s1.beginTransaction();
		 Query q=s1.createQuery("from User where name='"+name+"'");
	     List<User> li=q.list();
	      User count=li.get(0);
	     User user=(User)s1.get(User.class,count.getId());
	    
		 return new ModelAndView("orderConfirmation","User",user);
	 }
	 
	 @RequestMapping(value="viewCart1",method=RequestMethod.GET)
	    public ModelAndView fun1090()
	    {
	    	return new ModelAndView ("viewCart1");
	    }
	 @RequestMapping(value="checkOutCancelled",method=RequestMethod.GET)
	    public ModelAndView fun1091()
	    {
	    	return new ModelAndView ("checkOutCancelled");
	    }
	 @RequestMapping(value="thankCustomer",method=RequestMethod.GET)
	    public ModelAndView fun1092()
	    {
	    	return new ModelAndView ("thankCustomer");
	    }
	
	
	 
	 
}
