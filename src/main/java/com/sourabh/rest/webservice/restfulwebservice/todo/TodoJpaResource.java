package com.sourabh.rest.webservice.restfulwebservice.todo;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TodoJpaResource {

	@Autowired
	public TodoService  todoService;
	
	@Autowired
	public TodoJpaRepository todoJpaRepository;
	
	@GetMapping("/jpa/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username){
		List list = todoJpaRepository.findByUsername(username);
		System.out.println("LIST +++++++++++++ =" + list);
		return list;
		//return todoService.findAll();
	}
	
	@GetMapping("/jpa/users/{username}/todos/{id}")
	public Todo getTodo(@PathVariable String username, @PathVariable long id){
	return	todoJpaRepository.findById(id).get();
		//return todoService.findById(id);
		
	}
	
	@DeleteMapping("/jpa/users/{username}/todos/{id}")
	public ResponseEntity deleteTodo(@PathVariable String username, @PathVariable long id){
		
		//Todo todo = todoService.deleteById(id);
		todoJpaRepository.deleteById(id);
		
		
			return ResponseEntity.noContent().build();
		
		
		//return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/jpa/users/{username}/todos/{id}")
	public ResponseEntity updateTodo(@PathVariable String username, @PathVariable long id, @RequestBody Todo todo){
		//Todo updatetodo = todoService.save(todo);
		
		todoJpaRepository.save(todo);
		
		return new ResponseEntity<Todo>(todo, HttpStatus.OK);
		
	}
	
	@PostMapping("/jpa/users/{username}/todos")
	public ResponseEntity createTodo(@PathVariable String username, @RequestBody Todo todo){
		//Todo savetodo = todoService.save(todo);
		
		todo.setUsername(username);
		
		Todo createTodo = todoJpaRepository.save(todo);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createTodo.getId()).toUri(); 
		return ResponseEntity.created(uri).build();
	}
	
}
