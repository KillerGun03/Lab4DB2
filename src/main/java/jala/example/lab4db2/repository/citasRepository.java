package jala.example.lab4db2.repository;

import jala.example.lab4db2.model.Citas;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Esta es la interfaz del repositorio para 'Citas'.
 * Extiende MongoRepository para proporcionar métodos CRUD para el modelo Citas.
 */
public interface citasRepository extends MongoRepository<Citas, String>{
}
