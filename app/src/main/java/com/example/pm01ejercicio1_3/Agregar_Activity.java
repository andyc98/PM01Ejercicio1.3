package com.example.pm01ejercicio1_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pm01ejercicio1_3.Config.SQLiteConnection;
import com.example.pm01ejercicio1_3.Config.SQLiteConsult;

public class Agregar_Activity extends AppCompatActivity {
    EditText nombres, apellidos, edad, correo, direccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        nombres = (EditText) findViewById(R.id.Txt_nombre);
        apellidos = (EditText) findViewById(R.id.Txt_apellidos);
        edad = (EditText) findViewById(R.id.Txt_edad);
        correo = (EditText) findViewById(R.id.Txt_correo);
        direccion = (EditText) findViewById(R.id.Txt_direccion);
        Button save = (Button) findViewById(R.id.btn_salvar);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save_persons();
            }
        });
    }

    private void save_persons()
    {
        SQLiteConnection connect = new SQLiteConnection(this, SQLiteConsult.NameDatabase, null, 1);
        SQLiteDatabase db =connect.getWritableDatabase();

        ContentValues val = new ContentValues();
        val.put(SQLiteConsult.nombres, nombres.getText().toString());
        val.put(SQLiteConsult.apellidos, apellidos.getText().toString());
        val.put(SQLiteConsult.edad, edad.getText().toString());
        val.put(SQLiteConsult.correo, correo.getText().toString());
        val.put(SQLiteConsult.direccion, direccion.getText().toString());

        Long resul = db.insert(SQLiteConsult.tablaPersonas, SQLiteConsult.id, val);
        if (resul.longValue()>0){
            Toast.makeText(getApplicationContext(), "Registro ingresado : Codigo " + resul.toString(),Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(getApplicationContext(), "No se ha podido ingresar el registro", Toast.LENGTH_LONG).show();
        }
        db.close();

        clear_screen();
    }

    private void clear_screen()
    {
        nombres.setText("");
        apellidos.setText("");
        edad.setText("");
        correo.setText("");
        direccion.setText("");
    }
}