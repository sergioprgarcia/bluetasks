package br.com.sergio.bluetasks.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.sergio.bluetasks.domain.task.Task;

@Repository
public interface TaskRepository extends PagingAndSortingRepository<Task, Integer>{
	
	Task findByDescription(String description);

}
