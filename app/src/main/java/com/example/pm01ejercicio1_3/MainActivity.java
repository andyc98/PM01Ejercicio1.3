package com.example.pm01ejercicio1_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button agregar = (Button) findViewById(R.id.btn_agregar);
        Button consult = (Button) findViewById(R.id.btn_listado);
        Button lis = (Button) findViewById(R.id.Btn_list);

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Agregar_Activity.class);
                startActivity(intent);
            }
        });

        consult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Visualizer_Activity.class);
                startActivity(intent);
            }
        });

        lis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), List_Activity.class);
                startActivity(intent);
            }
        });

    }
}