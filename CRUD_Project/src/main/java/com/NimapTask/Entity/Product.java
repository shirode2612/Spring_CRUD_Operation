package com.NimapTask.Entity;

import javax.persistence.Entity;

import javax.persistence.Id;

@Entity
public class Product {
	
	@Id
    private	int pid;
	private	String pname;
	private	int p_price;
	private String p_discount;
	
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Product(int pid, String pname, int p_price, String p_discount) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.p_price = p_price;
		this.p_discount = p_discount;
	}



	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getP_price() {
		return p_price;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}


	public String getP_discount() {
		return p_discount;
	}


	public void setP_discount(String p_discount) {
		this.p_discount = p_discount;
	}


	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", p_price=" + p_price + ", p_discount=" + p_discount + "]";
	}
	
	

}
