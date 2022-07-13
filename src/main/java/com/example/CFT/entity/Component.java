package com.example.CFT.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Component {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ComponentId;
    private String Category;
    private String SeriesNumber;
    private String Manufacturer;
    private String Price;
    private String InStock;
    private String Properties;
}
