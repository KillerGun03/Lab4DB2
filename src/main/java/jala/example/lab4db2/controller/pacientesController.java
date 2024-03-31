package jala.example.lab4db2.controller;

import jala.example.lab4db2.model.Pacientes;
import jala.example.lab4db2.repository.pacientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class pacientesController {
    @Autowired
    private pacientesRepository repository;

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

    @PostMapping
    public ResponseEntity<Pacientes> createPacientes(@RequestBody Pacientes paciente) {
        try {
            Pacientes _paciente = repository.save(paciente);
            return new ResponseEntity<>(_paciente, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

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

