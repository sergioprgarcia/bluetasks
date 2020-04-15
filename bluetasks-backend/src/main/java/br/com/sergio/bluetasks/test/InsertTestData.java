package br.com.sergio.bluetasks.test;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.com.sergio.bluetasks.domain.task.Task;
import br.com.sergio.bluetasks.domain.user.AppUser;
import br.com.sergio.bluetasks.repository.AppUserRepository;
import br.com.sergio.bluetasks.repository.TaskRepository;

@Component
public class InsertTestData {

	private TaskRepository taskRepository;
	private AppUserRepository appUserRepository;
	
	@Autowired
	public InsertTestData(TaskRepository taskRepository, AppUserRepository appUserRepository) {
		this.taskRepository = taskRepository;
		this.appUserRepository = appUserRepository;
	}
	
	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		//TODO: Criptografar senha
		AppUser appUser = new AppUser("Sergio", "abc", "Sergio Garcia");
		appUserRepository.save(appUser);
		
		LocalDate baseDate = LocalDate.parse("2025-02-01");
		for (int i = 1; i <= 10; i++) {
			Task task = new Task("Tarefa #" + i, baseDate.plusDays(i), false);
			task.setAppUser(appUser);
			taskRepository.save(task);
		}
	}
	
}
