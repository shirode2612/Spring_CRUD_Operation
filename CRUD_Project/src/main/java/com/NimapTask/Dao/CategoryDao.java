package com.NimapTask.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.NimapTask.Entity.Category;

@Repository
public class CategoryDao {
	
	@Autowired
	SessionFactory factory;
	
	public Category saveAlldata(@RequestBody Category category) 
	{
		    Session session = factory.openSession();
		    		    
		    Transaction tr = session.beginTransaction();
		    
		    session.save(category);
		    
		    tr.commit();
		    
		    return category;
		 
	}
	
	public Category getCategory(@PathVariable int cid)
	{
		
		Session session = factory.openSession();
		 
     	Category category = session.get(Category.class, cid);  // get works only on id
     	
     	return category;
     	
	}

	public Category updateCategory(@RequestBody Category category)
	{
		Session session = factory.openSession();
		
	    Transaction tr = session.beginTransaction();
	    
	    session.update(category);
	    
	    tr.commit();

		return category;
		
	}
	
	

	public Category deleteCategory(int cid) 
	{
		Session session = factory.openSession();

        Category category = session.get(Category.class, cid);  // get works only on id
		
	    Transaction tr = session.beginTransaction();
	    
	    session.delete(category);
	    
	    tr.commit();

		return category;
	}
	
	public List<Category> getAllCategory()
	{
		
		Session session = factory.openSession();
		 		
		Criteria criteria = session.createCriteria(Category.class);
				
		List<Category> list = criteria.list();
		
		return list;
		
	}
	
	public boolean updateCategoryBtId(int cid)
	
	{
		Session session = factory.openSession();
		
	    Transaction tr = session.beginTransaction();
	    
	    session.update(cid);
	    
	    tr.commit();
	    
	    session.close();

		return true;

	}
	


}
