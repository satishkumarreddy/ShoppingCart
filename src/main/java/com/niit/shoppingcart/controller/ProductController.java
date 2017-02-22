package com.niit.shoppingcart.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.model.Product;
import com.niit.shoppingcart.model.Supplier;
@Controller
public class ProductController {

	@Autowired
	ProductDAO pd;
	@Autowired
	SupplierDAO sd;

	@ModelAttribute("Product")
	public Product createProduct() {
		return new Product();
	}

	@RequestMapping("/Products")
	public ModelAndView display6() {
		ModelAndView m4 = new ModelAndView("Products");
		return m4;
	}
	
	@RequestMapping("addpro")
	public ModelAndView display3() 
	{

		ModelAndView mv3 = new ModelAndView("addproduct");
//		mv3.addObject("supplier", new Supplier());
        List suppliers= sd.getAllSuppliers();
        mv3.addObject("supplier", suppliers);
        return mv3;
	}
	@RequestMapping("/viewproducts")
	public ModelAndView display8() 
	
	{
		ModelAndView m4 = new ModelAndView("viewproducts");
		return m4;
	}
	@RequestMapping("/viewproductsuser")
	public ModelAndView display10() 
	{
		ModelAndView m4 = new ModelAndView("viewproductsuser");
		return m4;
	}

	@RequestMapping("storeproduct")
	public String addProduct(HttpServletRequest request, @Valid @ModelAttribute("Product") Product product,BindingResult result) {
		if (result.hasErrors()) {
			return "addproduct";
		}
		
		String filename = product.getImg().getOriginalFilename();
		System.out.println(filename);
		product.setImage(filename);

		try {
			byte[] bytes = new byte[product.getImg().getInputStream().available()];
			product.getImg().getInputStream().read(bytes);
			BufferedInputStream buffer = new BufferedInputStream(product.getImg().getInputStream());
			MultipartFile file = product.getImg();
			String path = request.getServletContext().getRealPath("/") + "/WEB-INF/resources/images";
			File rootPath = new File(path);
			if (!rootPath.exists())
				rootPath.mkdirs();
			File store = new File(rootPath.getAbsolutePath() + "/" + filename);
			
			OutputStream os = new FileOutputStream(store);
			os.write(bytes);
		} catch (Exception e) {
			
		}
		pd.saveOrUpdate(product);
		return "viewproducts";

	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody String showList()
	{
		List list = pd.getAllProducts();
		Gson x = new Gson();
		String json = x.toJson(list);
		return json;
	}

	@RequestMapping("/delete")
	public ModelAndView deleteProduct(@RequestParam int id) {
		pd.delete(id);
		ModelAndView m1 = new ModelAndView("viewproducts");
		return m1;
	}
	

	@RequestMapping("viewproduct")
	public ModelAndView display12() {
		ModelAndView m6 = new ModelAndView("viewproduct");
		return m6;

	}
	@RequestMapping("viewproductuser")
	public ModelAndView display13() {
		ModelAndView m6 = new ModelAndView("viewproductuser");
		return m6;

	}
@ModelAttribute ("Product")
public ModelAndView display9(){
	ModelAndView m9 = new ModelAndView("Product");
	return m9;
}
	@RequestMapping(value = "viewproduct", method = RequestMethod.GET)
	public ModelAndView viewPro(@RequestParam int id, @ModelAttribute Product products) {
		Product product = pd.getSingleProduct(id);
		return new ModelAndView("viewproduct", "product", product);
	}
	@RequestMapping(value = "viewproductuser", method = RequestMethod.GET)
	public ModelAndView viewProuser(@RequestParam int id, @ModelAttribute Product products) {
		Product product = pd.getSingleProduct(id);
		return new ModelAndView("viewproductuser", "product", product);
	}
	 		 
	  		 
	 @RequestMapping(value="editproduct",method=RequestMethod.GET)
	    public ModelAndView editPro(@RequestParam int id){
		 Product product1=pd.getSingleProduct(id);
	    	return new ModelAndView("editproduct","Product",product1);
	    }
	 @RequestMapping(value="update",method=RequestMethod.POST)
	    public ModelAndView updateProduct(HttpServletRequest request,@Valid @ModelAttribute("Product")Product product,BindingResult result)
	    {
	    	
	    	String filename=product.getImg().getOriginalFilename();
	    	
	    	product.setImage(filename);
     	
	    	try{
     		byte[] bytes=new byte[product.getImg().getInputStream().available()];
     		product.getImg().getInputStream().read(bytes);
     		BufferedInputStream buffer=new BufferedInputStream(product.getImg().getInputStream());
     		MultipartFile file=product.getImg();
     		String path=request.getServletContext().getRealPath("/")+"/WEB-INF/resources/images";
     		File rootPath=new File(path);
     		if(!rootPath.exists())
     			rootPath.mkdirs();
     		File store=new File(rootPath.getAbsolutePath()+"/"+filename);
     		
     		OutputStream os=new FileOutputStream(store);
     		os.write(bytes);
     		//product.setId(1);
     		
	    	pd.updateProduct(product);
	    	}
	    	catch(Exception e)
	    	{
	    		
	    	}
	    	return new ModelAndView("viewproducts");
	    }	 
}
