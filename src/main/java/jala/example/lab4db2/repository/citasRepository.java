package jala.example.lab4db2.repository;

import jala.example.lab4db2.model.Citas;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface citasRepository extends MongoRepository<Citas, String>{
}
