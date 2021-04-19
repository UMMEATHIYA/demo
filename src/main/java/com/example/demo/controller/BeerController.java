package com.example.demo.controller;

import com.example.demo.dao.BeerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.BeerModel;
import com.example.demo.service.BeerService;

import java.util.List;

@RestController
public class BeerController {

    private Environment environment;
    private BeerService beerService;
    private BeerDao beerDao;
    @Autowired
    public BeerController(Environment environment, BeerService beerService, BeerDao beerDao) {
        super();
        this.environment = environment;
        this.beerService = beerService;
        this.beerDao = beerDao;
    }
    @GetMapping("/")
    public ResponseEntity<?> getStatus()
    {
        return ResponseEntity.ok("app is up listening on port: "+environment.getProperty("local.server.port"));
    }
    @GetMapping("/beers")
    public ResponseEntity<List<BeerModel>> getAllBeer()
    {
        return ResponseEntity.status(HttpStatus.OK).body(beerService.getAllBeer());
    }
    @PostMapping("/beer/create")
    public ResponseEntity<BeerModel> createCustomer(@RequestBody BeerModel beerModel)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(beerService.CreateBeerModel(beerModel));
    }
    @DeleteMapping("/beer/{id}")
    public ResponseEntity<List<BeerModel>> deleteById(@PathVariable("id") Integer id) {
        beerService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
    @PutMapping("/beer/{id}")
    public ResponseEntity<BeerModel> UpdateById(@PathVariable("id") Integer id ,@RequestBody BeerModel beer) {
        BeerModel b = beerService.findById(id);
        b.setBeerName(beer.getBeerName());
        b.setCost(beer.getCost());
        final BeerModel Updated = beerDao.save(b);
        return ResponseEntity.status(HttpStatus.OK).body(Updated);
    }

}