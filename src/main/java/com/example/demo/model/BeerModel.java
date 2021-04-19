package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BeerModel {
    @Id
    private Integer id;
    private String beerName;
    private Integer  cost;
    public BeerModel() {
        super();
    }
    public BeerModel(Integer id, String beerName, Integer cost) {
        super();
        this.id = id;
        this.beerName = beerName;
        this.cost = cost;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id =id;
    }
    public String getBeerName() {
        return beerName;
    }
    public void setBeerName(String beerName) {
        this.beerName = beerName;
    }
    public Integer getCost() {
        return cost;
    }
    public void setCost(Integer cost) {
        this.cost = cost;
    }



}