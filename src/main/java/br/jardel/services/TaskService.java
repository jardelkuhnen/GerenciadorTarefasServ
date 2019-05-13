package br.jardel.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.jardel.entities.Tarefa;
import br.jardel.repositories.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	public List<Tarefa> listAll(){
		return taskRepository.findAll();
	}

	public void save(Tarefa task) {
		if(task != null && task.getNome() != null) {
			taskRepository.save(task);
		}	
	}

	public void delete(Long id) {

		Optional<Tarefa> task = taskRepository.findById(id);
		
		if(task != null) {
			taskRepository.delete(task.get());
		}
	}
	
}
