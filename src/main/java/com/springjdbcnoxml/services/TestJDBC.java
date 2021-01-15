package com.springjdbcnoxml.services;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class TestJDBC {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		JdbcTemplate jdbcTemplate = context.getBean("jdbcTemplate",JdbcTemplate.class);
		List<Customer> customers = jdbcTemplate.query("select * from customers", new BeanPropertyRowMapper<Customer>(Customer.class));
		for (Customer c : customers) {
			System.out.println(c);
		}
	}
}
