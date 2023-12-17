package com.company.springframework.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

@Table(name = "tbl_empleados")
@Entity
@Getter
@Setter
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @Column(precision = 10, scale = 2)
    private BigDecimal salario;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaIngreso;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "departamentoId")
    private Departamento departamento;


    @Transient
    public Date getFechaIngresoSqlDate() {
        return (fechaIngreso != null) ? Date.valueOf(fechaIngreso) : null;
    }

    @Transient
    public Long getDepartamentoId() {
        return departamento != null ? departamento.getId() : null;
    }



}



