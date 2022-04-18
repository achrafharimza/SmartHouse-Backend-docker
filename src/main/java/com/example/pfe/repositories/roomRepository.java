package com.example.pfe.repositories;


import com.example.pfe.entities.RoomEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface roomRepository extends MongoRepository<RoomEntity,String> {
    RoomEntity findRoomEntityById(String id);

}
