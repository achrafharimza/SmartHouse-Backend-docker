package com.example.pfe.repositories;

import com.example.pfe.entities.DeviceEntity;

import com.example.pfe.entities.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface deviceRepository extends MongoRepository<DeviceEntity,String> {
    void deleteById(String id);
    DeviceEntity deleteDeviceEntityByNom(String nom);
    DeviceEntity findDeviceEntityById(String id);
}
