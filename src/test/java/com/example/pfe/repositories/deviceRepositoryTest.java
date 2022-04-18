package com.example.pfe.repositories;

import com.example.pfe.entities.DeviceEntity;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@AutoConfigureDataMongo


class deviceRepositoryTest {
    @Autowired
    private deviceRepository clientRepository;

    DeviceEntity device =new DeviceEntity(null,"deviceTEST","ON","1ere","bedroom");

    @Test
    void all() {

        List<DeviceEntity> devices = clientRepository.findAll()  ;

        assertEquals(23,devices.stream().count());

    }
    @Test
    void create() {
        DeviceEntity saved =clientRepository.save(device);
        System.out.println(saved);
        assertNotNull(saved.getId());

    }
    @Test
    void update() {
        DeviceEntity device2 =new DeviceEntity("1","TV","ON","1ere","bedroom");
        device2.setNom("TVupdated");
        DeviceEntity saved =clientRepository.save(device2);
        assertEquals("TVupdated",saved.getNom());
        assertEquals("1",saved.getId());

    }
    @Test
    void byid() {
        DeviceEntity finded =clientRepository.findDeviceEntityById("1");
        assertEquals("TVupdated",finded.getNom());

    }

    @Test
    void delete() {


        DeviceEntity deleted =clientRepository.deleteDeviceEntityByNom("deviceTEST");
        assertNotNull(deleted);

    }
}