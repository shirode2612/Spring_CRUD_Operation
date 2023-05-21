package com.NimapTask.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NimapTask.Entity.Product;
import com.NimapTask.Entity.ProductInfo;
import com.NimapTask.Service.ProductService;


@RequestMapping("productapi")
@RestController
public class ProductController {

	@Autowired
	ProductService service ;
	
	@PostMapping("product/{cid}")
	public Product addProduct(@RequestBody Product product,@PathVariable int cid)
	{
		return service.addProduct(product, cid);
		
	}
	
	@RequestMapping("allProducts")
	public List<Product> getallProducts()
	{
		return service.getallProducts();
	}
	
	@RequestMapping("getProductbyid/{pid}")
	public List<ProductInfo> getProductbyid(@PathVariable int pid)
	{
		return service.getProductbyid(pid);
	}
	
	@PutMapping("product")
	public Product updateProduct(@RequestBody Product clientProduct)
	{
		return service.updateProduct(clientProduct);

	}
	
	@RequestMapping("deleteProduct/{pid}")
	public Product deleteProduct(@PathVariable int pid)
	{
		return service.deleteProductbyid(pid);
	}

}
