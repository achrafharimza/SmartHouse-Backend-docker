package com.example.pfe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceDto {

    private String id;
    private String nom;
    private String status;
    private String floor;
    private String room;


}
