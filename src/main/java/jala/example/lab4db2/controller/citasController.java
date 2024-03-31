package jala.example.lab4db2.controller;

import jala.example.lab4db2.model.Citas;
import jala.example.lab4db2.repository.citasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/citas")
public class citasController {
    @Autowired
    private citasRepository repository;

    @GetMapping
    public ResponseEntity<List<Citas>> getAllCitas() {
        try {
            List<Citas> Cinta = repository.findAll();
            if (Cinta.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(Cinta, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Citas> createCita(@RequestBody Citas cita) {
        try {
            Citas _cita = repository.save(cita);
            return new ResponseEntity<>(_cita, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Citas> updateCita(@PathVariable String id, @RequestBody Citas cita) {
        Optional<Citas> citaData = repository.findById(id);

        if (citaData.isPresent()) {
            Citas _cita = citaData.get();
            _cita.setPacientes(cita.getPacientes());
            _cita.setMedicos(cita.getMedicos());
            _cita.setFechaHora(cita.getFechaHora());
            _cita.setMotivo(cita.getMotivo());
            _cita.setEstado(cita.getEstado());
            return new ResponseEntity<>(repository.save(_cita), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletecitas(@PathVariable String id) {
        try {
            repository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
