package com.NimapTask.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.NimapTask.Dao.ProductDao;
import com.NimapTask.Entity.Product;
import com.NimapTask.Entity.ProductInfo;

@Service
public class ProductService 
{
	@Autowired()
	ProductDao dao;
	
	public Product addProduct(Product product, int cid)
	{
		return dao.addProduct(product, cid);
		
	}
	
	public List<Product> getallProducts()
	{
		return dao.getallProducts();
	}
	

	public List<ProductInfo> getProductbyid(int pid)
	{
		return dao.getProductbyid(pid);
	}
	
	
	public Product updateProduct(@RequestBody Product clientProduct)
	{
				return dao.updateProduct(clientProduct);

	}

	
	public Product deleteProductbyid(int pid)
	{
		return dao.deleteProductbyid(pid);
	}

	

}
