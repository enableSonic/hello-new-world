package com.geeky.springmvc.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.geeky.springmvc.model.Customer;

@Controller
public class CustomerController {
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView onSubmit(@ModelAttribute("customerForm") @Valid Customer customer, BindingResult result) {
		System.out.println(customer);
		if (result.hasErrors()) {
			return new ModelAndView("CustomerForm");
		}
		return new ModelAndView("CustomerSuccess","customer",customer);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String newCustomer() {
		return "CustomerForm";
	}
	
	@ModelAttribute("customerForm")
	public Customer customerForm() {
		Customer cust = new Customer();
		//Make "Spring MVC" as default checked value
		cust.setFavFramework(new String []{"Spring MVC"});
 
		//Make "Make" as default radio button selected value
		cust.setSex("M");
 
		//make "Hibernate" as the default java skills selection
		cust.setJavaSkills("Hibernate");
 
		//initilize a hidden value
		cust.setSecretValue("I'm hidden value");
 
		return cust;
	}
	
	@ModelAttribute("webFrameworkList")
	public List<String> getWebFrameworkList() {
		List<String> webFrameworkList = new ArrayList<String>();
		webFrameworkList.add("Spring MVC");
		webFrameworkList.add("Struts 1");
		webFrameworkList.add("Struts 2");
		webFrameworkList.add("JSF");
		webFrameworkList.add("Apache Wicket");
		return webFrameworkList;
	}
	
	@ModelAttribute("numberList")
	public List<String> getNumberList() {
		List<String> numberList = new ArrayList<String>();
		numberList.add("Number 1");
		numberList.add("Number 2");
		numberList.add("Number 3");
		numberList.add("Number 4");
		numberList.add("Number 5");
		return numberList;
	}
	
	@ModelAttribute("countryList")
	public Map<String,String> getCountryList() {
		Map<String,String> country = new LinkedHashMap<String,String>();
		country.put("US", "United Stated");
		country.put("THAI", "Thailand");
		country.put("CHINA", "China");
		country.put("SG", "Singapore");
		country.put("MY", "Malaysia");
		return country;
	}
	
	@ModelAttribute("javaSkillsList")
	public Map<String,String> getJavaSkillsList() {
		Map<String,String> javaSkill = new LinkedHashMap<String,String>();
		javaSkill.put("Hibernate", "Hibernate");
		javaSkill.put("Spring", "Spring");
		javaSkill.put("Apache Wicket", "Apache Wicket");
		javaSkill.put("Struts", "Struts");
		return javaSkill;
	}
}
