package com.example.pfe.services.impl;

import com.example.pfe.dto.FloorDto;
import com.example.pfe.dto.services.IMapClassWithDto;
import com.example.pfe.entities.FloorEntity;
import com.example.pfe.repositories.floorRepository;
import com.example.pfe.services.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class FloorServiceImpl implements FloorService {
    @Autowired
    private floorRepository floorRepository;
    @Autowired
    IMapClassWithDto<FloorEntity, FloorDto> Mapping;

    @Override
    public List<FloorDto> getALL() {
        List<FloorEntity> rooms = floorRepository.findAll()  ;
        return Mapping.convertListToListDto(rooms,FloorDto.class);
    }

    @Override
    public FloorDto getById(String id) {
        FloorEntity floor = floorRepository.findFloorEntityById(id);

        if(floor == null) throw new RuntimeException("Address not found");

        return Mapping.convertToDto(floor, FloorDto.class);
    }

    @Override
    public FloorDto create(FloorDto device) {
        FloorEntity roomEntity = Mapping.convertToEntity(device, FloorEntity.class);

        roomEntity = floorRepository.save(roomEntity);

        return Mapping.convertToDto(roomEntity, FloorDto.class);
    }

    @Override
    public FloorDto update(FloorDto floorDto, String id) {
        FloorEntity floorEntity = floorRepository.findFloorEntityById(id);

        if(floorEntity == null) throw new RuntimeException("Address not found");

        floorEntity = Mapping.convertToEntity(floorDto, FloorEntity.class);

        floorEntity = floorRepository.save(floorEntity);

        return Mapping.convertToDto(floorEntity, FloorDto.class);
    }

    @Override
    public void delete(String id) {
        FloorEntity deleted = floorRepository.findFloorEntityById(id);

        if(deleted == null) throw new RuntimeException("Address not found");

        floorRepository.deleteById(id);
    }
}
