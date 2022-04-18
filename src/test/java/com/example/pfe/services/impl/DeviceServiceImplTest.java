package com.example.pfe.services.impl;

import com.example.pfe.dto.DeviceDto;
import com.example.pfe.dto.services.IMapClassWithDto;
import com.example.pfe.entities.DeviceEntity;
import com.example.pfe.repositories.deviceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class DeviceServiceImplTest {
    @Mock
    private deviceRepository clientRepository;
    @Mock
    IMapClassWithDto<DeviceEntity, DeviceDto> clientMapping;
    @InjectMocks
    DeviceServiceImpl clientServiceImpl;

    DeviceDto deviceDto=new DeviceDto("1","TV","ON","1ere","bedroom");
    DeviceEntity deviceEntity=new DeviceEntity("2","TV","ON","1ere","bedroom");

    List<DeviceDto> listdeviceDto= new ArrayList<>(Arrays.asList(deviceDto));
    List<DeviceEntity> listdeviceEntity= new ArrayList<>(Arrays.asList(deviceEntity));

    @Test
    void getALL() {
        Mockito.when(clientRepository.findAll()).thenReturn(listdeviceEntity);
        Mockito.when(clientMapping.convertListToListDto(listdeviceEntity,DeviceDto.class)).thenReturn(listdeviceDto);

        List<DeviceDto> cltFinded=clientServiceImpl.getALL();
        assertEquals(cltFinded,listdeviceDto);
    }


    @Test
    void create() {
        Mockito.when(clientMapping.convertToEntity(deviceDto,DeviceEntity.class)).thenReturn(deviceEntity);
        Mockito.when(clientRepository.save(deviceEntity)).thenReturn(deviceEntity);
        Mockito.when(clientMapping.convertToDto(deviceEntity,DeviceDto.class)).thenReturn(deviceDto);

        DeviceDto cltFinded=clientServiceImpl.create(deviceDto);
        assertEquals(cltFinded,deviceDto);
    }

    @Test
    void getById() {
        Mockito.when(clientRepository.findDeviceEntityById("1")).thenReturn(deviceEntity);
        Mockito.when(clientMapping.convertToDto(deviceEntity,DeviceDto.class)).thenReturn(deviceDto);

        DeviceDto finded=clientServiceImpl.getById("1");
        assertEquals(finded,deviceDto);
    }

    @Test
    void delete() {
        Mockito.when(clientRepository.findDeviceEntityById("1")).thenReturn(deviceEntity);


        boolean cltFinded=clientServiceImpl.delete("1");
        assertEquals(true,cltFinded);
    }

    @Test
    void update() {
        Mockito.when(clientMapping.convertToEntity(deviceDto,DeviceEntity.class)).thenReturn(deviceEntity);
        Mockito.when(clientRepository.save(deviceEntity)).thenReturn(deviceEntity);
        Mockito.when(clientMapping.convertToDto(deviceEntity,DeviceDto.class)).thenReturn(deviceDto);

        DeviceDto finded=clientServiceImpl.create(deviceDto);
        assertEquals(finded,deviceDto);
    }
}