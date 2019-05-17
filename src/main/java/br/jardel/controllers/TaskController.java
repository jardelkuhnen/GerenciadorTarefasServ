package br.jardel.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/loadById")
	public ResponseEntity<Tarefa> loadById(@RequestParam Long id) {
		Tarefa tarefa = taskService.loadById(id);
		return ResponseEntity.ok(tarefa);
	}
	
	@PostMapping("/update")
	public ResponseEntity<?> update(Tarefa tarefa){
		taskService.update(tarefa);
		return ResponseEntity.ok().build();
	}
	
}
