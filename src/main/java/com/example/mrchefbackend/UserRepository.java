package com.example.mrchefbackend;

import org.springframework.data.repository.CrudRepository;


// Este código será CREADO AUTOMATICAMENTE por Spring en un Bean llamado userRepository
// CRUD significa Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);

}
