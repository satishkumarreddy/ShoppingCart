package com.niit.shoppingcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Entity
@Table
@Component
public class Supplier {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private int id;
	@NotNull
	private int supid;
	@NotNull(message="supname cannot be null")
	@Size(min = 2, max = 14)
	private String supname;
	@NotNull(message="supname cannot be null")
	@Size(min = 2, max = 14)
	private String suplocation;
	@NotNull(message="supname cannot be null")
	private int categoryid;
	@NotNull(message="supname cannot be null")
	@Size(min = 2, max = 14)
	private String categoryname;
	@NotNull(message="supname cannot be null")
	private int productid;
	@NotNull(message="supname cannot be null")
	@Size(min = 2, max = 14)
	private String productname;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSupid() {
		return supid;
	}
	public void setSupid(int supid) {
		this.supid = supid;
	}
	public String getSupname() {
		return supname;
	}
	public void setSupname(String supname) {
		this.supname = supname;
	}
	public String getSuplocation() {
		return suplocation;
	}
	public void setSuplocation(String suplocation) {
		this.suplocation = suplocation;
	}
	public int getCategoryid() {
		return categoryid;
	}
	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}
	public String getCategoryname() {
		return categoryname;
	}
	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	
}
