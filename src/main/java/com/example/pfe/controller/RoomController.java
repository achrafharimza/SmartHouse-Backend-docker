package com.example.pfe.controller;

import com.example.pfe.dto.RoomDto;
import com.example.pfe.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {
    @Autowired
    private RoomService roomService;

    //------- All  : -------------------------------------------------------------------

    @GetMapping("/")
    public ResponseEntity<List<RoomDto>> getAll(){
        List<RoomDto> roomDto = roomService.getALL();
        return ResponseEntity.ok(roomDto);
    }

    //------- Add  : ------------------------------------------------------------------

    @PostMapping("/")

    public ResponseEntity<RoomDto> create(@RequestBody RoomDto roomDto )  {


        RoomDto added = roomService.create(roomDto);

        return new ResponseEntity<RoomDto>(added, HttpStatus.CREATED);

    }
    //------- Delete  : --------------------------------------------------------------

    @DeleteMapping("/delete/{id}")

    public ResponseEntity<String> delete(@PathVariable String id){
        roomService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    //------- Update  : --------------------------------------------------------------

    @PutMapping("/update/{id}")

    public ResponseEntity<RoomDto> update(@PathVariable String id, @RequestBody RoomDto roomDto){
        RoomDto updated = roomService.update(roomDto, id);

        return new ResponseEntity<RoomDto>(updated, HttpStatus.OK);

    }

    //------- Get By Id  : --------------------------------------------------------------

    @GetMapping("/{id}")

    public ResponseEntity<RoomDto> getById(@PathVariable String id){
        RoomDto roomDto = roomService.getById(id);

        return new ResponseEntity<RoomDto>(roomDto, HttpStatus.OK);

    }
}

