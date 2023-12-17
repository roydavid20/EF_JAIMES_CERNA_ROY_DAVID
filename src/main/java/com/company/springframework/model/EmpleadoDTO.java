package com.company.springframework.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class EmpleadoDTO {
    private Long id;
    private String nombre;
    private BigDecimal salario;
    private LocalDate fechaIngreso;
    private String departamentoDescripcion;


    public EmpleadoDTO(Long id, String nombre, BigDecimal salario, LocalDate fechaIngreso, String departamentoDescripcion) {
        this.id = id;
        this.nombre = nombre;
        this.salario = salario;
        this.fechaIngreso = fechaIngreso;
        this.departamentoDescripcion = departamentoDescripcion;
    }

    public java.sql.Date getFechaIngresoSqlDate() {
        return fechaIngreso != null ? java.sql.Date.valueOf(fechaIngreso) : null;
    }


}

