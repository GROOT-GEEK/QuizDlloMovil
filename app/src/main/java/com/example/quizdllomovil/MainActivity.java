package com.example.quizdllomovil;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2,btn3;
    EditText edtxt1;
    int puntos = 0 , intentos = 0, suma=0;
    String numero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conectar();
        int [] vector = new int[5];

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intentos += 1;
                /**
                 *Genera el valor  aleatorio en la posición arreglo
                 **/
                for (int i=0;i<vector.length;i++) {
                    vector[i] = (int) (Math.random() * 900) + 100;
                    numero = Integer.toString(vector[i]);
                    /**
                     *Verificamos si el numero es capicua,velidando el primer y ultimo digito.
                     **/
                    if (Character.getNumericValue(numero.charAt(0))== Character.getNumericValue(numero.charAt(2))) {
                        puntos += 5;
                        Notificaciones(numero + " Es capicua obtienes 5 puntos");
                        System.out.println(numero + " Es capicua obtienes 5 puntos");
                    }
                    /**
                     *Verifica uno a uno los 3 digitos para saber cual es 5.
                     **/
                    suma = 0;
                    for (int x = 0; x < numero.length(); x++) {
                        suma+= Character.getNumericValue(numero.charAt(x));
                        if (numero.charAt(x) == '5') {
                            puntos += 1;
                            Notificaciones(numero + " contiene el 5 obtienes 1 puntos");
                            System.out.println(numero + " contiene el 5 obtienes 1 puntos");
                        }
                    }

                    if (suma>12) {
                        puntos += 3;
                        Notificaciones(numero + " la suma >12 obtienes 3 puntos");
                        System.out.println(numero + " la suma >12 obtienes 3 puntos");
                    }
                }
                edtxt1.setText(Arrays.toString(vector));
                btn3.setText("Puntos: " + Integer.toString(puntos));
                btn2.setText("Intentos: " + Integer.toString(intentos) );
                if (puntos >=20){
                    Notificaciones("GANASTE");
                    puntos = 0;
                    intentos =0;
                    btn3.setText("Puntos: " + Integer.toString(puntos));
                    btn2.setText("Intentos: " + Integer.toString(intentos) );
                }





            }


        });



    }

    private void conectar() {
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        edtxt1=findViewById(R.id.edtxt1);
    }

    private void Notificaciones(String text){
        Toast.makeText(this,text,Toast.LENGTH_LONG).show();
    }


}