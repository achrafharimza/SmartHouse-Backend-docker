package com.example.pfe.services;

import com.example.pfe.dto.FloorDto;

import java.util.List;

public interface FloorService  {
    List<FloorDto> getALL();
    FloorDto getById(String id);
    FloorDto create(FloorDto floorDto);
    FloorDto update(FloorDto floorDto, String id);
    void delete(String id);

}
