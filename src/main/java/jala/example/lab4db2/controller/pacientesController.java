package jala.example.lab4db2.controller;

import jala.example.lab4db2.model.Pacientes;
import jala.example.lab4db2.repository.pacientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Este es un Controlador Rest para manejar las solicitudes relacionadas con la coleccion 'pacientes'.
 * Utiliza el pacientesRepository para interactuar con la base de datos.
 */
@RestController
@RequestMapping("/pacientes")
public class pacientesController {
    @Autowired
    private pacientesRepository repository;

    /**
     * Este método devuelve todos los registros de la coleccion pacientes de la base de datos.
     * Si no se encuentran registros, devuelve un estado NO_CONTENT.
     */
    @GetMapping
    public ResponseEntity<List<Pacientes>> getAllPacientes() {
        try {
            List<Pacientes> pacientes = repository.findAll();
            if (pacientes.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(pacientes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Este método crea un nuevo registro en la coleccion pacientes en la base de datos.
     * El nuevo paciente se pasa en el cuerpo de la solicitud.
     */
    @PostMapping
    public ResponseEntity<Pacientes> createPacientes(@RequestBody Pacientes paciente) {
        try {
            Pacientes _paciente = repository.save(paciente);
            return new ResponseEntity<>(_paciente, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Este método actualiza un paciente existente de la base de datos.
     * El id del paciente a actualizar se pasa en la variable de la ruta y los nuevos datos se pasan en el cuerpo de la solicitud.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Pacientes> updatePacientes(@PathVariable String id, @RequestBody Pacientes paciente) {
        Optional<Pacientes> pacienteData = repository.findById(id);

        if (pacienteData.isPresent()) {
            Pacientes _paciente = pacienteData.get();
            _paciente.setNombre(paciente.getNombre());
            _paciente.setFechaNacimiento(paciente.getFechaNacimiento());
            _paciente.setGenero(paciente.getGenero());
            _paciente.setDireccion(paciente.getDireccion());
            _paciente.setTelefono(paciente.getTelefono());
            _paciente.setSeguroMedico(paciente.getSeguroMedico());
            _paciente.setAlergias(paciente.getAlergias());
            _paciente.setTipoSangre(paciente.getTipoSangre());
            return new ResponseEntity<>(repository.save(_paciente), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Este método elimina un paciente de la base de datos.
     * El id del paciente a eliminar se pasa en la variable de la ruta.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePacientes(@PathVariable String id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

