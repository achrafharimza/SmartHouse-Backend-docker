package com.example.pfe.services;

import com.example.pfe.dto.RoomDto;
import com.example.pfe.dto.RoomDto;

import java.util.List;

public interface RoomService {
    List<RoomDto> getALL();
    RoomDto getById(String id);
    RoomDto create(RoomDto floorDto);
    RoomDto update(RoomDto floorDto, String id);
    void delete(String id);
}
