package com.NimapTask.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.NimapTask.Entity.Category;
import com.NimapTask.Exception.ObjectNotFoundException;
import com.NimapTask.Service.CategoryService;

@RestController
@RequestMapping("categoryapi")
public class CategoryController {

	@Autowired
	CategoryService service;
	
	@PostMapping("saveCategory")
	public Category saveAllData(@RequestBody Category category)
	{
		 service.saveAllData(category);
		 return category;
	}
	
	@RequestMapping("getCategory/{cid}")
	public Category getCategory(@PathVariable int cid)
	{
		Category category = service.getCategory(cid);
		
		
		if(category==null)
		{
			throw new ObjectNotFoundException("No Record Found With cid "+cid);
		}else
		{
			return category;
		}
		
	}
	
	@PutMapping("updateCategory")
	public Category updateCategory(@RequestBody Category category)
	{
		return service.updateCategory(category);
		
	}
	
	@RequestMapping("deleteCategory/{cid}")
	public Category deleteCategory(@PathVariable int cid)
	{
		return service.deleteCategory(cid);
		
	}
	
	@RequestMapping("getAllCategory")
	public List<Category> getAllCategory()
	{
		return service.getAllCategory();	
	}
	
	@PutMapping("update/{cid}")
	public boolean updateCategoryBtId(@PathVariable int cid)
	{
		boolean update = service.updateCategoryBtId(cid);
		return update;
	}

}
