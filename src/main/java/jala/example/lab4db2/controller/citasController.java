package jala.example.lab4db2.controller;

import jala.example.lab4db2.model.Citas;
import jala.example.lab4db2.repository.citasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Este es un Controlador Rest para manejar las solicitudes relacionadas con 'Citas'.
 * Utiliza el citasRepository para interactuar con la base de datos.
 */
@RestController
@RequestMapping("/citas")
public class citasController {
    // Inyección automática del citasRepository para usar sus métodos.
    @Autowired
    private citasRepository repository;

    /**
     * Este método devuelve todas las Citas que hay en la base de datos.
     * Si no se encuentran Citas, devuelve un estado NO_CONTENT.
     */
    @GetMapping
    public ResponseEntity<List<Citas>> getAllCitas() {
        try {
            List<Citas> Cinta = repository.findAll();
            if (Cinta.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(Cinta, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Este método crea una nueva Cita en la base de datos.
     * La nueva Cita se pasa en el cuerpo de la solicitud.
     */
    @PostMapping
    public ResponseEntity<Citas> createCita(@RequestBody Citas cita) {
        try {
            Citas _cita = repository.save(cita);
            return new ResponseEntity<>(_cita, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Este método actualiza una Cita existente en la base de datos.
     * El id de la Cita a actualizar se pasa en la variable de la ruta y los nuevos datos se pasan en el cuerpo de la solicitud.
     */
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

    /**
     * Este método elimina una Cita de la base de datos.
     * El id de la Cita a eliminar se pasa en la variable de la ruta.
     */
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
