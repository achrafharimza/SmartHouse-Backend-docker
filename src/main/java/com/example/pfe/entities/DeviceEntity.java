package com.example.pfe.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Document(value = "devices")
public class DeviceEntity  {

    @Id
    private String id;

    private String nom;
    private String status;
    private String floor;
    private String room;


}
