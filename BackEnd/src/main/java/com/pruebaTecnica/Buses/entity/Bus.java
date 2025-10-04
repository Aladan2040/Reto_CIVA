package com.pruebaTecnica.Buses.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "buses")
@NoArgsConstructor
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numeroBus;
    private String placa;
    private LocalDateTime fechaCreacion = LocalDateTime.now();
    private String caracteristicas;
    private boolean estado = true;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;
}
