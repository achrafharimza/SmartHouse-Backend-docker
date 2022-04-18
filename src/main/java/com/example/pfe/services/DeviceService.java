package com.example.pfe.services;

import com.example.pfe.dto.DeviceDto;

import java.util.List;

public interface DeviceService {
    List<DeviceDto> getALL();
    DeviceDto getById(String id);
    DeviceDto create(DeviceDto device);
    DeviceDto update(DeviceDto deviceDto, String id);
    boolean delete(String id);





}
