package com.example.pfe.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.io.Serializable;

/*
@Entity
@Table(name = "users")*/
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Document(value = "users")
public class UserEntity  {


//    private static final long serialVersionUID = 1L;

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String nom;


    private String prenom;


    private String email;

    private String password;


}
