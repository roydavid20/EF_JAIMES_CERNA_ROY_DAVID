package com.company.springframework.repository;

import com.company.springframework.model.Empleado;
import com.company.springframework.model.EmpleadoDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {

    List<Empleado> findByNombre(String nombre);

    List<Empleado> findByNombreContaining(String cadena);

    List<Empleado> findByNombreStartingWith(String cadena);

    List<Empleado> findBySalario(BigDecimal salario);

    List<Empleado> findBySalarioGreaterThan(BigDecimal salario);

    List<Empleado> findBySalarioGreaterThanEqual(BigDecimal salario);

    List<Empleado> findBySalarioBetween(BigDecimal minSalario, BigDecimal maxSalario);

    List<Empleado> findFirst2BySalarioBetween(BigDecimal minSalario, BigDecimal maxSalario);

    List<Empleado> findByDepartamentoDescripcionOrderByFechaIngresoAsc(String departamentoDescripcion);

    @Query("SELECT new com.company.springframework.model.EmpleadoDTO(" +
            "e.id, e.nombre, e.salario, e.fechaIngreso, d.descripcion) " +
            "FROM Empleado e JOIN e.departamento d")
    List<EmpleadoDTO> findAllWithDepartamentoDescripcion();
}
