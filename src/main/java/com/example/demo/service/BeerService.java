package com.example.demo.service;

import com.example.demo.model.BeerModel;

import java.util.List;


public interface BeerService {
        public BeerModel CreateBeerModel(BeerModel beerModel);
        public List<BeerModel> getAllBeer();
        public void deleteById(Integer id);
        public BeerModel findById(Integer id);
}
