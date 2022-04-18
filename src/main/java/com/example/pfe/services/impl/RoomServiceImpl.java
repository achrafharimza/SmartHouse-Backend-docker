package com.example.pfe.services.impl;

import com.example.pfe.dto.RoomDto;
import com.example.pfe.dto.RoomDto;
import com.example.pfe.dto.services.IMapClassWithDto;
import com.example.pfe.entities.RoomEntity;
import com.example.pfe.entities.RoomEntity;
import com.example.pfe.repositories.roomRepository;
import com.example.pfe.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    roomRepository roomRepository;

    @Autowired
    IMapClassWithDto<RoomEntity, RoomDto> Mapping;



    @Override
    public List<RoomDto> getALL() {


        List<RoomEntity> rooms = roomRepository.findAll()  ;
        return Mapping.convertListToListDto(rooms,RoomDto.class);
    }

    @Override
    public RoomDto getById(String id) {
        RoomEntity roomEntity = roomRepository.findRoomEntityById(id);

        if(roomEntity == null) throw new RuntimeException("Address not found");

        return Mapping.convertToDto(roomEntity, RoomDto.class);
    }

    @Override
    public RoomDto create(RoomDto device) {
        RoomEntity roomEntity = Mapping.convertToEntity(device, RoomEntity.class);

        roomEntity = roomRepository.save(roomEntity);

        return Mapping.convertToDto(roomEntity, RoomDto.class);
    }

    @Override
    public RoomDto update(RoomDto floorDto, String id) {
        RoomEntity roomEntity = roomRepository.findRoomEntityById(id);

        if(roomEntity == null) throw new RuntimeException("Address not found");

        roomEntity = Mapping.convertToEntity(floorDto, RoomEntity.class);

        roomEntity = roomRepository.save(roomEntity);

        return Mapping.convertToDto(roomEntity, RoomDto.class);
    }

    @Override
    public void delete(String id) {
        RoomEntity deleted = roomRepository.findRoomEntityById(id);

        if(deleted == null) throw new RuntimeException("Address not found");

        roomRepository.deleteById(id);

    }
}
