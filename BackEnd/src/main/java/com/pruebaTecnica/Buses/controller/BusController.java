package com.pruebaTecnica.Buses.controller;

import com.pruebaTecnica.Buses.entity.Bus;
import com.pruebaTecnica.Buses.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bus")
@CrossOrigin(origins = "http://localhost:3000")
public class BusController {

    @Autowired
    private BusService busService;

    @GetMapping
    public ResponseEntity<Page<Bus>> getAllBuses(Pageable pageable){
        Page<Bus> page = busService.finAll(pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bus> getBusById(@PathVariable Long id){
        Bus b = busService.findById(id);
        if(b == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(b);
    }
}
