package com.example.pfe.controller;

import com.example.pfe.dto.FloorDto;
import com.example.pfe.services.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/floor")
public class FloorController {
    @Autowired
    private FloorService floorService;

    //------- All  : -------------------------------------------------------------------

    @GetMapping("/")
    public ResponseEntity<List<FloorDto>> getAll(){
        List<FloorDto> floorDto = floorService.getALL();
        return ResponseEntity.ok(floorDto);
    }

    //------- Add  : ------------------------------------------------------------------

    @PostMapping("/")

    public ResponseEntity<FloorDto> create(@RequestBody FloorDto floorDto )  {


        FloorDto added = floorService.create(floorDto);

        return new ResponseEntity<FloorDto>(added, HttpStatus.CREATED);

    }
    //------- Delete  : --------------------------------------------------------------

    @DeleteMapping("/delete/{id}")

    public ResponseEntity<String> delete(@PathVariable String id){
        floorService.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
    //------- Update  : --------------------------------------------------------------

    @PutMapping("/update/{id}")

    public ResponseEntity<FloorDto> update(@PathVariable String id, @RequestBody FloorDto floorDto){
        FloorDto updated = floorService.update(floorDto, id);

        return new ResponseEntity<FloorDto>(updated, HttpStatus.OK);

    }

    //------- Get By Id  : --------------------------------------------------------------

    @GetMapping("/{id}")

    public ResponseEntity<FloorDto> getById(@PathVariable String id){
        FloorDto floorDto = floorService.getById(id);

        return new ResponseEntity<FloorDto>(floorDto, HttpStatus.OK);

    }



}
