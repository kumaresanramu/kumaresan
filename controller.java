package simple.webpage.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import simple.webpage.Dao.insertdao;
import simple.webpage.Dao.insertdaoimpl;
import simple.webpage.entity.Person;


@Controller
public class HomeController {
	@PersistenceContext
	    private EntityManager manager;
  @Autowired
  insertdao dao;
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		int id=1;
		String name="kumar1";
		String country="india";
		System.out.println(manager.find(Person.class, id)); 

		  List<Person> employees = manager.createQuery("Select a From Person a", Person.class).getResultList();
		  for(Person p : employees) {
			  System.out.println(p.getCountry()+"" + p.getName()+""+p.getId());
			 }
		//dao.insert(id, name, country);
		  String query="Select a From Person a";
		  Query q=this.manager.createQuery(query);
		  employees=q.getResultList();
		  System.out.println("empl"+employees);
		  
		return new ModelAndView("home");
	}
}
