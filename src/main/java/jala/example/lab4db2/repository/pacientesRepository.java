package jala.example.lab4db2.repository;

import jala.example.lab4db2.model.Pacientes;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface pacientesRepository extends MongoRepository<Pacientes, String> {
}
