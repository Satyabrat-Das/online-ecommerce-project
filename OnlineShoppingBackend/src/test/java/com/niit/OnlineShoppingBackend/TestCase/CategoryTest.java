package com.niit.OnlineShoppingBackend.TestCase;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.OnlineShoppingBackend.dao.CategoryDAO;
import com.niit.OnlineShoppingBackend.model.Category;

public class CategoryTest {

	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;

	private static Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.OnlineShoppingBackend");
		context.refresh();

		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");

	}
	@Ignore
	@Test
	public void testAddCategory() {
		category = new Category();
		category.setName("laptop");
		category.setDescription("Thease are all regarding to laptop");
		category.setImageURL("3.png");

		assertEquals("category is added Successfully", true, categoryDAO.add(category));
	}

	@Ignore
	@Test

	public void testGetCategory() {
		category = categoryDAO.get(1);
		assertEquals("category is retreved Successfully", "Mobile", category.getName());
	}

	@Test 
	public void testDeleteCategory(){
		  
		  category = categoryDAO.get(5);
		  
		  assertEquals("category is deleteed Successfully",true,categoryDAO.delete(
		  category));
	}
}
