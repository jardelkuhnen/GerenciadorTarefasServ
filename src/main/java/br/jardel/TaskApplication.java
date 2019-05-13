package br.jardel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.jardel.entities.Tarefa;
import br.jardel.repositories.TaskRepository;

@SpringBootApplication
public class TaskApplication {

	@Autowired
	private TaskRepository taskRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(TaskApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandRunner() {
		return args -> {
			
			Tarefa task = new Tarefa();
			task.setNome("Dormir");
			task.setConcluida(true);
			taskRepo.save(task);
			
			Tarefa task2 = new Tarefa();
			task2.setNome("Estudar");
			task2.setConcluida(true);
			taskRepo.save(task2);
		};
	}
}
