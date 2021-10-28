package com.example.pm01ejercicio1_3.Tables;

public class Persons
{

    private Integer id;
    private String nombres;
    private String apellidos;
    private Integer edad;
    private String correo;
    private String direccion;

    public Persons(Integer id, String nombres, String apellidos, Integer edad, String correo, String direccion) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.correo = correo;
        this.direccion = direccion;
    }

    public Persons() {

    }

    // Get y Set ID
    public Integer getId() { return id; }

    public void setId(Integer id) {
        this.id = id;
    }

    // Get y Set Nombres
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    // Get y Set Apellidos
    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    // Get y Set Edad
    public Integer getEdad() { return edad;}

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    // Get y Set Correo
    public String getCorreo() { return correo; }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    // Get y Set Direccion
    public String getDireccion() { return direccion;}

    public void setDireccion(String direccion) { this.direccion = direccion;}

}
