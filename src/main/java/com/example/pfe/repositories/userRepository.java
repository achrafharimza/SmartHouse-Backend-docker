package com.example.pfe.repositories;

import com.example.pfe.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepository extends MongoRepository<UserEntity,String> {
    UserEntity findByEmail(String email);
    UserEntity findUserEntityById(String id);
}
