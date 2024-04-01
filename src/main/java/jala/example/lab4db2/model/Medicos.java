package jala.example.lab4db2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Esta es la clase modelo para 'Medicos'.
 * Se mapea a la colección 'medicos' en la base de datos.
 */
@Document(collection = "medicos")
public class Medicos {
    // El ID del medico.
    @Id
    private String id;
    // El nombre del medico
    private String nombre;
    // La especialidad del medico
    private String especialidad;
    // Los anos de experiencia del medico
    private int experiencia;
    // El horario de atencion del medico
    private String horarioAtencion;
    // El consultorio del medico
    private String consultorio;

    // Getters y setters para cada campo.

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public String getHorarioAtencion() {
        return horarioAtencion;
    }

    public void setHorarioAtencion(String horarioAtencion) {
        this.horarioAtencion = horarioAtencion;
    }

    public String getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(String consultorio) {
        this.consultorio = consultorio;
    }
}
