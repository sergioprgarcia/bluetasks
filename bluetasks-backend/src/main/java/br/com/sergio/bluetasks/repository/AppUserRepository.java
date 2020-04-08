package br.com.sergio.bluetasks.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.sergio.bluetasks.domain.user.AppUser;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Integer> {
	
	AppUser findByUsername(String username);
}
