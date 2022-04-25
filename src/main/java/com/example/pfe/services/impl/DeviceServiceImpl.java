package com.example.pfe.services.impl;

import com.example.pfe.dto.DeviceDto;
import com.example.pfe.dto.services.IMapClassWithDto;
import com.example.pfe.entities.DeviceEntity;
import com.example.pfe.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.pfe.repositories.deviceRepository;

import java.util.List;
@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    deviceRepository deviceRepository;


    @Autowired
    IMapClassWithDto<DeviceEntity, DeviceDto> Mapping;

    @Override
    public List<DeviceDto> getALL() {



        List<DeviceEntity> devices = deviceRepository.findAll()  ;
        return Mapping.convertListToListDto(devices,DeviceDto.class);
    }

    @Override
    public DeviceDto create(DeviceDto device) {

        DeviceEntity deviceEntity = Mapping.convertToEntity(device, DeviceEntity.class);

        deviceEntity = deviceRepository.save(deviceEntity);

        return Mapping.convertToDto(deviceEntity, DeviceDto.class);
    }

    @Override
    public DeviceDto getById(String id) {
        DeviceEntity device = deviceRepository.findDeviceEntityById(id);

        return Mapping.convertToDto(device,DeviceDto.class);
    }



    @Override
    public boolean delete(String id) {
        DeviceEntity device = deviceRepository.findDeviceEntityById(id);

        if(device == null) throw new RuntimeException("Address not found");

        deviceRepository.deleteById(id);
        return true;
    }

    @Override
    public DeviceDto update(DeviceDto deviceDto, String id) {
        DeviceEntity deviceEntity = Mapping.convertToEntity(deviceDto, DeviceEntity.class);
        deviceEntity.setId(id);
        deviceEntity = deviceRepository.save(deviceEntity);

        return Mapping.convertToDto(deviceEntity, DeviceDto.class);
    }

    @Override
    public DeviceDto updateStatus(String status, String id) {
        DeviceEntity device = deviceRepository.findDeviceEntityById(id);


        device.setStatus(status);
        device = deviceRepository.save(device);

        return Mapping.convertToDto(device, DeviceDto.class);
    }
}
