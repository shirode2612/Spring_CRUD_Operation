package com.NimapTask.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.NimapTask.Dao.CategoryDao;
import com.NimapTask.Entity.Category;

@Service
public class CategoryService {
	
	@Autowired
	CategoryDao dao;
	
	public Category saveAllData(Category category)
	{
		return dao.saveAlldata(category);
	}
	
	public Category getCategory(int cid)
	{
		return dao.getCategory(cid);
	}
	public Category updateCategory(Category category)
	{
		return dao.updateCategory(category);
	}

	public Category deleteCategory(int cid) 
	{
		return dao.deleteCategory(cid);
	}
	
	public List<Category> getAllCategory()
	{
		return dao.getAllCategory();
	}
	
	public boolean updateCategoryBtId(int cid)
	{
		return dao.updateCategoryBtId(cid);
	}
	

	

}
