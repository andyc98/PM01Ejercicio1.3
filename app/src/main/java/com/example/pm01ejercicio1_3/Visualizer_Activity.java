package com.example.pm01ejercicio1_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pm01ejercicio1_3.Config.SQLiteConnection;
import com.example.pm01ejercicio1_3.Config.SQLiteConsult;

public class Visualizer_Activity extends AppCompatActivity {
    SQLiteConnection conexion;
    EditText id, nombres, apellidos, edad, correo, direccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizer);

        conexion = new SQLiteConnection(this, SQLiteConsult.NameDatabase, null, 1);

        //Botones para gestiones

        Button search = (Button) findViewById(R.id.Btn_search);
        Button delete = (Button) findViewById(R.id.Btn_delete);
        Button update = (Button) findViewById(R.id.Btn_update);

        //Variables de visualización
        id = (EditText) findViewById(R.id.Txt_visualizer_ID);
        nombres = (EditText) findViewById(R.id.Txt_visualizer_nombres);
        apellidos = (EditText) findViewById(R.id.Txt_visualizer_apellidos);
        edad = (EditText) findViewById(R.id.Txt_visualizer_edad);
        correo = (EditText) findViewById(R.id.Txt_visualizer_correo);
        direccion = (EditText) findViewById(R.id.Txt_visualizer_dirrecion);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Delete();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Update();
            }
        });

    }


    private void search(){
        SQLiteDatabase db = conexion.getWritableDatabase();

        String[] params = {id.getText().toString()};
        String[] fields = {SQLiteConsult.nombres,
                SQLiteConsult.apellidos,
                SQLiteConsult.correo,
                SQLiteConsult.edad,
                SQLiteConsult.direccion};

        String wherecond = SQLiteConsult.id + "=?";

        try {

            Cursor cdata = db.query(SQLiteConsult.tablaPersonas, fields, wherecond, params, null, null, null);

            cdata.moveToFirst();
            nombres.setText(cdata.getString(0));
            apellidos.setText(cdata.getString(1));
            correo.setText(cdata.getString(2));
            edad.setText(cdata.getString(3));
            direccion.setText(cdata.getString(4));
            Toast.makeText(getApplicationContext(), "Consultado con exito", Toast.LENGTH_LONG).show();
        } catch (Exception ex) {
            Toast.makeText(getApplicationContext(), "Elemento no encontrado", Toast.LENGTH_LONG).show();
        }
    }

    private void Delete()
    {
        SQLiteDatabase db = conexion.getWritableDatabase();
        String [] params = {id.getText().toString()};
        String wherecond = SQLiteConsult.id + "=?";
        db.delete(SQLiteConsult.tablaPersonas, wherecond, params);
        Toast.makeText(getApplicationContext(), "Dato eliminado", Toast.LENGTH_LONG).show();
        ClearScreen();
    }

    private void ClearScreen() {
    }

    private void Update()
    {
        SQLiteDatabase db = conexion.getWritableDatabase();
        String [] params = {id.getText().toString()};
        ContentValues valores = new ContentValues();
        valores.put(SQLiteConsult.nombres, nombres.getText().toString());
        valores.put(SQLiteConsult.apellidos, apellidos.getText().toString());
        valores.put(SQLiteConsult.edad, edad.getText().toString());
        valores.put(SQLiteConsult.correo, correo.getText().toString());
        valores.put(SQLiteConsult.direccion, direccion.getText().toString());
        db.update(SQLiteConsult.tablaPersonas, valores, SQLiteConsult.id + "=?", params);
        Toast.makeText(getApplicationContext(), "Dato actualizado", Toast.LENGTH_LONG).show();
        ClearScreen();


    }



}