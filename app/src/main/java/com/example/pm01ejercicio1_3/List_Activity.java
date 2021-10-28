package com.example.pm01ejercicio1_3;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.pm01ejercicio1_3.Config.SQLiteConnection;
import com.example.pm01ejercicio1_3.Config.SQLiteConsult;
import com.example.pm01ejercicio1_3.Tables.Persons;

import java.util.ArrayList;

public class List_Activity extends AppCompatActivity {

    SQLiteConnection conexion;
    ListView listapersonas;
    ArrayList<Persons> lista;
    ArrayList<String> ArregloPersonas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        conexion = new SQLiteConnection(this, SQLiteConsult.NameDatabase, null,1);
        listapersonas = (ListView) findViewById(R.id.listado);

        ObtenerListaPersonas();

        ArrayAdapter adp = new ArrayAdapter(this , android.R.layout.simple_list_item_1, ArregloPersonas);
        listapersonas.setAdapter(adp);




    }

    private void ObtenerListaPersonas()
    {
        SQLiteDatabase db = conexion.getReadableDatabase();
        Persons list_personas = null;
        lista = new ArrayList<Persons>();

        //cursor de base de datos: nos apoya a recorrer la informacion de la tabla a la cual consultamos

        Cursor cursor = db.rawQuery("SELECT * FROM " + SQLiteConsult.tablaPersonas, null);

        // recorremos la informacion del cursor
        while(cursor.moveToNext())
        {
            list_personas = new Persons();
            list_personas.setId(cursor.getInt(0));
            list_personas.setNombres(cursor.getString(1));
            list_personas.setApellidos(cursor.getString(2));
            list_personas.setEdad(cursor.getInt(3));
            list_personas.setCorreo(cursor.getString(4));
            list_personas.setDireccion(cursor.getString(5));

            lista.add(list_personas);

        }

        cursor.close();

        filllist();

    }

    private void filllist()
    {
        ArregloPersonas = new ArrayList<String>();
        for(int i = 0; i < lista.size();i++) {
            ArregloPersonas.add(lista.get(i).getId() + " | "
                    +lista.get(i).getNombres()+ " | "
                    +lista.get(i).getApellidos()+ " | "
                    +lista.get(i).getDireccion());
        }
    }
}