package jala.example.lab4db2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Esta es la clase modelo para 'Pacientes'.
 * Mapea a la colección 'pacientes' en la base de datos.
 */
@Document(collection = "pacientes")
public class Pacientes {
    // El ID del paciente.
    @Id
    private String id;
    // El nombre del paciente
    private String nombre;
    // La fecha de nacimiento del paciente
    private String fechaNacimiento;
    // El genero del paciente
    private String genero;
    // La direccion del paciente
    private String direccion;
    // El telefono del paciente
    private String telefono;
    // El numero de seguro medico del paciente
    private String seguroMedico;
    // Las alergias del paciente
    private String alergias;
    // El tipo de sangre del paciente
    private String tipoSangre;

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

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSeguroMedico() {
        return seguroMedico;
    }

    public void setSeguroMedico(String seguroMedico) {
        this.seguroMedico = seguroMedico;
    }

    public String getAlergias() {
        return alergias;
    }

    public void setAlergias(String alergias) {
        this.alergias = alergias;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }
}
