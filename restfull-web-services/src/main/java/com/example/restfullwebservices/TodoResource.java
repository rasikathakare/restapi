package com.example.restfullwebservices;

import java.net.URI;
import java.text.ParseException;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class TodoResource {

	@Autowired
	private TodoHardcodedService todoService;

	

	@GetMapping("/users/{username}/todos")
	public Iterable<Todo> getAllTodos(@PathVariable String username) {
		return todoService.findAll();
	}

	@GetMapping("/users/todos/{id}")
	public Todo getTodo(@PathVariable String username, @PathVariable long id) {
		return todoService.findById(id);
	}

	// DELETE /users/{username}/todos/{id}
	@DeleteMapping("/users/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@RequestBody Todo data) {

		todoService.deleteById(data);

		

		return ResponseEntity.notFound().build();
	}

/*	// Edit/Update a Todo
	// PUT /users/{user_name}/todos/{todo_id}
	@PutMapping("/users/todos/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id,
			@RequestBody Todo todo) { // method param is bound to req body
 
		 todoService.save(todo);

		return new ResponseEntity<Todo>(todo, HttpStatus.OK);
	}*/

	// creating todo
	@PostMapping("/users/todos/{id}")
	public ResponseEntity<Void> updateTodo( @RequestBody Todo todo) {

		Todo createdTodo = todoService.save(todo);

		// Location
		// Get current resource url
		/// {id}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Todo> addData(@RequestBody Todo data) {

		Todo todo = new Todo();

		System.out.println(data.getUsername());
		todo.setUsername(data.getUsername());
		todo.setTargetDate(data.getTargetDate());
		todo.setDescription(data.getDescription());
		todo.setDone(true);
		todoService.save(todo);

		return null;
	}

}
