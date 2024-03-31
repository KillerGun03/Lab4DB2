package jala.example.lab4db2.repository;

import jala.example.lab4db2.model.Medicos;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface medicosRepository extends MongoRepository<Medicos, String> {
}
