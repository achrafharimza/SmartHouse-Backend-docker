package com.example.pfe.repositories;


import com.example.pfe.entities.FloorEntity;
import com.example.pfe.entities.RoomEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface floorRepository extends MongoRepository<FloorEntity,String> {
    FloorEntity findFloorEntityById(String id);

}
