package br.jardel.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.jardel.entities.Tarefa;

public interface TaskRepository extends JpaRepository<Tarefa, Long>{

}
