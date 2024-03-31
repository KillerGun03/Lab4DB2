package jala.example.lab4db2.controller;

import jala.example.lab4db2.model.Medicos;
import jala.example.lab4db2.repository.medicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicos")
public class medicosController {
    @Autowired
    private medicosRepository repository;

    @GetMapping
    public ResponseEntity<List<Medicos>> getAllMedicos() {
        try {
            List<Medicos> medicos = repository.findAll();
            if (medicos.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(medicos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Medicos> createMedicos(@RequestBody Medicos medico) {
        try {
            Medicos _medico = repository.save(medico);
            return new ResponseEntity<>(_medico, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medicos> updateMedicos(@PathVariable String id, @RequestBody Medicos medico) {
        Optional<Medicos> medicoData = repository.findById(id);

        if (medicoData.isPresent()) {
            Medicos _medico = medicoData.get();
            _medico.setNombre(medico.getNombre());
            _medico.setEspecialidad(medico.getEspecialidad());
            _medico.setExperiencia(medico.getExperiencia());
            _medico.setHorarioAtencion(medico.getHorarioAtencion());
            _medico.setConsultorio(medico.getConsultorio());
            return new ResponseEntity<>(repository.save(_medico), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteMedicos(@PathVariable String id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}