package com.company.springframework.service;

import com.company.springframework.model.Empleado;
import com.company.springframework.model.EmpleadoDTO;

import java.util.List;

public interface EmpleadoService {
    Empleado guardarEmpleado(Empleado empleado);

    Empleado actualizarEmpleado(Empleado empleado);

    void eliminarEmpleado(Long id);

    Empleado obtenerEmpleado(Long id);

    List<Empleado> listarTodosLosEmpleados();

    // Declara el nuevo método
    List<EmpleadoDTO> listarTodosLosEmpleadosDTO();
}
