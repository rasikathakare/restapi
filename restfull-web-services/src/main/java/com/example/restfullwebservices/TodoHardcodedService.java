package com.example.restfullwebservices;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class TodoHardcodedService  {
	
	

	@Autowired
	private TodoRepository todoRepository;
	
	


	public Iterable<Todo> findAll() {
		return todoRepository.findAll();
	}


	
	public Todo save(Todo todo) {
		
		todoRepository.save(todo);
		
		return todo;
	}
	
	public Todo deleteById(Todo todo) {
	
		todoRepository.delete(todo);
		
		return null;
	}

	public Todo findById(long id) {
		
		todoRepository.findById((int) id);
		
		return null;
	}
	
}
