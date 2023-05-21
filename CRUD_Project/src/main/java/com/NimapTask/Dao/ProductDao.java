package com.NimapTask.Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.NimapTask.Entity.Category;
import com.NimapTask.Entity.Product;
import com.NimapTask.Entity.ProductInfo;

@Repository
public class ProductDao {
	
	@Autowired
	SessionFactory factory;
	

	public Product addProduct(@RequestBody Product product,@PathVariable int cid)
	{
		System.out.println("Categoty id is "+cid);
		
		Session session = factory.openSession();
		
		Category category = session.load(Category.class, cid);
		
		List<Product> productlist = category.getProduct();
		
		Transaction tr = session.beginTransaction();
		
		productlist.add(product);
		
		tr.commit();
		
		System.out.println("Product added into database");
		
		return product;
		
	}
	
	public List<Product> getallProducts()
	{
		Session session=factory.openSession();
		Criteria criteria=session.createCriteria(Product.class);
		List<Product> list=criteria.list();
		return list;
		// [pid=1 name=pen price=100] Product class object
		// Spring calls getter methods to read data of variables and then create JSON String
	}
	
	
	public List<ProductInfo> getProductbyid(int pid)
	{
		Session session=factory.openSession();
		
		@SuppressWarnings("deprecation")
		Query query=session.createSQLQuery("select product.pid,product.pname,product.p_price as price,product.p_discount as discpount,category.cid,category.cname from product join category on product.cid=category.cid and pid="+pid);
		
		List<Object[]> list=query.list();
		
		List<ProductInfo> arrayList=new ArrayList<ProductInfo>();
					
		for (Object[] array : list) 
		{
			arrayList.add(new ProductInfo((int)array[0], (String)array[1], (int)array[2],(String)array[3], (int)array[4], (String)array[5]));
		}
		
		return arrayList;
	}
	
	
	public Product updateProduct(@RequestBody Product clientProduct)
	{
				Session session=factory.openSession();
				
				Transaction transaction=session.beginTransaction();
				
				session.update(clientProduct);
								
				transaction.commit();
								
				return clientProduct;

	}

	
	public Product deleteProductbyid(int pid)
	{
		Session session=factory.openSession();
		Product product=session.get(Product.class,pid);
		
		Transaction tx=session.beginTransaction();
				session.delete(product);
		tx.commit();
		
		return product;
	}



}
