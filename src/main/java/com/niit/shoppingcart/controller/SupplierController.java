package com.niit.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Supplier;

@Controller
public class SupplierController 
{
	@Autowired
	SupplierDAO sd;
	
	
	@ModelAttribute("Supplier")
	public Supplier createSupplier() {
		return new Supplier();
	}

	
	
	@RequestMapping("/addsup")
	public ModelAndView fun1()
	{
		return new ModelAndView("addSupplier");
	}
	
	@RequestMapping("viewsuppliers")
	public ModelAndView display12() {
		ModelAndView m6 = new ModelAndView("viewsuppliers");
		
		return m6;

	}
	@RequestMapping(value = "viewsupplier/{id}", method = RequestMethod.GET)
	public ModelAndView viewSup(@PathVariable("id") int id, @ModelAttribute Supplier suppliers) {
		Supplier supplier = sd.getSingleSupplier(id);
		
		return new ModelAndView("viewsupplier", "supplier", supplier);
	}
	 
	 
	 @RequestMapping(value="editsupplier",method=RequestMethod.GET)
	    public ModelAndView editSup(@RequestParam int id){
		 Supplier supplier1=sd.getSingleSupplier(id);
	    	return new ModelAndView("editsupplier","Supplier",supplier1);
	    }
	 @RequestMapping(value="updatesupplier",method=RequestMethod.POST)
	    public String updateSupplier(HttpServletRequest request,@Valid @ModelAttribute("Supplier")Supplier editsup,BindingResult result,Model model)
	    {
			sd.update(editsup);
			return "redirect:/viewsuppliers";
	    }	
	 @RequestMapping("deletesupplier")
		public String deleteSupplier(@RequestParam int id) {
			sd.delete(id);
			
			return "redirect:/viewsuppliers";
		}
	@RequestMapping(value="storesupplier",method = RequestMethod.GET)
	public String addSupplier(HttpServletRequest request, @Valid @ModelAttribute("Supplier") Supplier supplier,
			BindingResult result)
	{
		
		
		if (result.hasErrors()) 
		{
			
			return "addSupplier";
		}
		sd.saveOrUpdate(supplier);
		return "redirect:/viewsuppliers";
}
	
	@RequestMapping(value = "listsup", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String showList()
	{
		List list = sd.getAllSuppliers();
		Gson x = new Gson();
		String json = x.toJson(list);
		return json;
	}
	@RequestMapping(value = "viewsupplier", method = RequestMethod.GET)
	public ModelAndView viewSup1(@RequestParam int id, @ModelAttribute Supplier suppliers) {
		Supplier supplier = sd.getSingleSupplier(id);
		return new ModelAndView("viewsupplier", "supplier", supplier);
	}
	
	
}
