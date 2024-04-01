package jala.example.lab4db2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Esta es la clase modelo para 'Citas'.
 * Se mapea a la colección 'citas' en la base de datos.
 */
@Document(collection = "citas")
public class Citas {
    // El ID de la cita.
    @Id
    private String id;

    // La fecha y hora de la cita.
    private String fechaHora;

    // El motivo de la cita.
    private String motivo;

    // El estado de la cita.
    private String estado;

    // Referencia al paciente asociado con esta cita.
    @DBRef
    private Pacientes pacientes;

    // Referencia al médico asociado con esta cita.
    @DBRef
    private Medicos medicos;

    // Getters y setters para cada campo.

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Pacientes getPacientes() {
        return pacientes;
    }

    public void setPacientes(Pacientes pacientes) {
        this.pacientes = pacientes;
    }

    public Medicos getMedicos() {
        return medicos;
    }

    public void setMedicos(Medicos medicos) {
        this.medicos = medicos;
    }
}
