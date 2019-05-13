package br.jardel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.jardel.entities.Tarefa;
import br.jardel.services.TaskService;

@CrossOrigin
@RestController
@RequestMapping("api/tasks")
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	
	@GetMapping("/listAll")
	public List<Tarefa> listAll(){
		return taskService.listAll();
	}
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Tarefa tarefa) {
		taskService.save(tarefa);
		return ResponseEntity.ok().build();
		
	}
	
	@DeleteMapping("/delete{id}")
	public ResponseEntity<?> delete(Long id){
		taskService.delete(id);
		return ResponseEntity.ok().build();
	}
	
}
