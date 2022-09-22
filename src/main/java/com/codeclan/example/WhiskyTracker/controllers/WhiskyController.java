package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/whiskies")
    public ResponseEntity<List<Whisky>> getWhiskyByYear(@RequestParam(name = "year") int year){
        return new ResponseEntity<>(whiskyRepository.findWhiskyByYear(year), HttpStatus.OK);
    }


    @GetMapping(value = "/whiskies/distillery/age")
    public ResponseEntity<List<Whisky>> getWhiskyFromDistilleryWithAge(@RequestParam(name = "name") String name, @RequestParam(name = "age") int age){
        return new ResponseEntity<>(whiskyRepository.findByDistilleryNameAndAge(name, age), HttpStatus.OK);
    }

    @GetMapping(value = "/whiskies/region")
    public ResponseEntity<List<Whisky>> getWhiskyByRegion(@RequestParam(name = "region") String region ){
        return new ResponseEntity<>(whiskyRepository.findWhiskyByDistilleryRegion(region), HttpStatus.OK);
    }




}
