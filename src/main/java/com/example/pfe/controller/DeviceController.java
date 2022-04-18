package com.example.pfe.controller;

import com.example.pfe.dto.DeviceDto;
import com.example.pfe.dto.UserDto;
import com.example.pfe.services.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/device")
public class DeviceController {

    @Autowired
     DeviceService deviceService;
    //------- All  : -------------------------------------------------------------------

    @GetMapping("/")
    public ResponseEntity<List<DeviceDto>> getAll(){
        List<DeviceDto> deviceDto = deviceService.getALL();
        return ResponseEntity.ok(deviceDto);
    }

    //------- Add  : ------------------------------------------------------------------

    @PostMapping("/")

    public ResponseEntity<DeviceDto> create(@RequestBody DeviceDto deviceDto )  {


        DeviceDto added = deviceService.create(deviceDto);

        return new ResponseEntity<DeviceDto>(added, HttpStatus.CREATED);

    }
    //------- Delete  : --------------------------------------------------------------

    @DeleteMapping("/{id}")

    public ResponseEntity<Boolean> delete(@PathVariable String id){
        Boolean isdeleted= deviceService.delete(id);

        return new ResponseEntity<Boolean>(isdeleted,HttpStatus.NO_CONTENT);

    }
    //------- Update  : --------------------------------------------------------------

    @PutMapping("/{id}")

    public ResponseEntity<DeviceDto> update(@PathVariable String id, @RequestBody DeviceDto deviceDto){
        DeviceDto updated = deviceService.update(deviceDto, id);

        return new ResponseEntity<DeviceDto>(updated, HttpStatus.CREATED);

    }

    //------- Get By Id  : --------------------------------------------------------------

    @GetMapping("/{id}")

    public ResponseEntity<DeviceDto> getById(@PathVariable String id){
        DeviceDto deviceDto = deviceService.getById(id);

        return new ResponseEntity<DeviceDto>(deviceDto, HttpStatus.OK);

    }



}
















