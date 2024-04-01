package jala.example.lab4db2.repository;

import jala.example.lab4db2.model.Medicos;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Esta es la interfaz del repositorio para 'Medicos'.
 * Extiende MongoRepository para proporcionar métodos CRUD para el modelo Medicos.
 */
public interface medicosRepository extends MongoRepository<Medicos, String> {
}
