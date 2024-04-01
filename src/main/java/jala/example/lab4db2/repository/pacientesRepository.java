package jala.example.lab4db2.repository;

import jala.example.lab4db2.model.Pacientes;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Esta es la interfaz del repositorio para 'Pacientes'.
 * Extiende MongoRepository para proporcionar métodos CRUD para el modelo Pacientes.
 */
public interface pacientesRepository extends MongoRepository<Pacientes, String> {
}
