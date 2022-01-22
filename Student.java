package com.example.daviscollegeapp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer stId;
    @Column(nullable = false, unique = true,length = 50)
    String stfName;
    String stlName;
    String stprogr;

}
