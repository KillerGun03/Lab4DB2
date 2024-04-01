package jala.example.lab4db2.controller;

import jala.example.lab4db2.model.Medicos;
import jala.example.lab4db2.repository.medicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Este es un Controlador Rest para manejar las solicitudes relacionadas con 'Medicos'.
 * Utiliza el medicosRepository para interactuar con la base de datos.
 */
@RestController
@RequestMapping("/medicos")
public class medicosController {
    // Inyección automática del medicosRepository para usar sus métodos.
    @Autowired
    private medicosRepository repository;

    /**
     * Este método devuelve todos los Medicos de la base de datos.
     * Si no se encuentran Medicos, devuelve un estado NO_CONTENT.
     */
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

    /**
     * Este método crea un nuevo registro en la coleccion medicos en la base de datos.
     * El nuevo medico se pasa en el cuerpo de la solicitud.
     */
    @PostMapping
    public ResponseEntity<Medicos> createMedicos(@RequestBody Medicos medico) {
        try {
            Medicos _medico = repository.save(medico);
            return new ResponseEntity<>(_medico, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Este método actualiza un medico existente en la base de datos.
     * El id del medico a actualizar se pasa en la variable de la ruta y los nuevos datos se pasan en el cuerpo de la solicitud.
     */
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

    /**
     * Este método elimina un medico de la base de datos.
     * El id del medico a eliminar se pasa en la variable de la ruta.
     */
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