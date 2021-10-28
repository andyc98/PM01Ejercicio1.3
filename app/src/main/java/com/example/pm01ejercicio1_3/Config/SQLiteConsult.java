package com.example.pm01ejercicio1_3.Config;

public class SQLiteConsult {

    // Datos para la creación de la base de datos y tabla
    public static final String NameDatabase = "PM01DB";
    public static final String tablaPersonas = "personas";


    // Campos de la base de datoss
    public static final String id = "id";
    public static final String nombres = "nombres";
    public static final String apellidos = "apellidos";
    public static final String edad = "edad";
    public static final String correo = "correo";
    public static final String direccion = "direccion";

    // Transacciones

    public static final String CreateTablePersonas = "CREATE TABLE personas (id INTEGER PRIMARY KEY AUTOINCREMENT,"+
            "nombres TEXT, apellidos TEXT, edad INTEGER, correo TEXT, direccion TEXT)";

    public static final String DROPTablePersonas = "DROP TABLE IF EXISTS personas";


}
