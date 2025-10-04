package com.pruebaTecnica.Buses.service;

import com.pruebaTecnica.Buses.entity.Bus;
import com.pruebaTecnica.Buses.repository.BusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@Service
public class BusService {
    @Autowired
    private BusRepository busRepository;

    public Page<Bus> finAll(Pageable pageable){
        return busRepository.findAll(pageable);
    }

    public Bus findById(Long id) {
        return busRepository.findById(id).orElse(null);
    }
}
