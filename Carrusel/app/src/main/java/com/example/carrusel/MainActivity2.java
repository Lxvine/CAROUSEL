package com.example.carrusel;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class MainActivity2 extends AppCompatActivity {

    ImageView iv;
    ImageButton back, forward;

    Spinner images;

    int pic = 0;
    boolean right = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Objects.requireNonNull(getSupportActionBar()).hide();

        iv = findViewById(R.id.imageView);
        back = findViewById(R.id.leftButton);
        forward = findViewById(R.id.rightButton);

        // Arrays de las imagenes y de sus nombres:
        int[] imagesArray = {R.drawable.arco, R.drawable.coliseo, R.drawable.cristo, R.drawable.eiffel, R.drawable.libertad, R.drawable.sagrada, R.drawable.sirena};
        final String[] nameImagesArray = {"Arco del triunfo - París", "Coliseo - Roma", "Cristo del Corcovado - Rio de Janeiro", "Torre Eiffel - París", "Estatua de la libertad - Nueva York", "Sagrada Familia - Barcelona", "La Sirenita - Copenhage"};

        images = findViewById(R.id.imagesSpinner);

        // Spinner que permite desplegar un cuadro de texto para elegir la imagen mostrada:

        ArrayAdapter<CharSequence> adapterImages = ArrayAdapter.createFromResource(this,R.array.imagesOpciones,android.R.layout.simple_spinner_item);

        images.setAdapter(adapterImages);

        images.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l){

                switch (i) {
                    case 0:
                        iv.setImageResource(imagesArray[0]);
                        Toast.makeText(MainActivity2.this, "La imagen que se muestra es: " + nameImagesArray[pic], Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        iv.setImageResource(imagesArray[1]);
                        Toast.makeText(MainActivity2.this, "La imagen que se muestra es: " + nameImagesArray[1], Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        iv.setImageResource(imagesArray[2]);
                        Toast.makeText(MainActivity2.this, "La imagen que se muestra es: " + nameImagesArray[2], Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        iv.setImageResource(imagesArray[3]);
                        Toast.makeText(MainActivity2.this, "La imagen que se muestra es: " + nameImagesArray[3], Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        iv.setImageResource(imagesArray[4]);
                        Toast.makeText(MainActivity2.this, "La imagen que se muestra es: " + nameImagesArray[4], Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        iv.setImageResource(imagesArray[5]);
                        Toast.makeText(MainActivity2.this, "La imagen que se muestra es: " + nameImagesArray[5], Toast.LENGTH_SHORT).show();
                        break;
                    case 6:
                        iv.setImageResource(imagesArray[6]);
                        Toast.makeText(MainActivity2.this, "La imagen que se muestra es: " + nameImagesArray[6], Toast.LENGTH_SHORT).show();
                        break;

                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        // Método para el click en la imagen, dependiendo de la orientación seleccionada hará una cosa u otra y siempre controlará el tamaño del array para nunca saltar excepción:

        iv.setOnClickListener(view -> {

            if(right){
                pic ++;
            } else {
                pic --;
            } if (pic == imagesArray.length) {
                pic = 0;
            } else if (pic == -1){
                pic = imagesArray.length -1;
            }
            iv.setImageResource(imagesArray[pic]);

            Toast.makeText(MainActivity2.this, "La imagen que se muestra es: " + nameImagesArray[pic], Toast.LENGTH_SHORT).show();

        });

        // Método del botón para la orientación invertida:

        back.setOnClickListener(view -> {
            right = false;

            iv.setImageResource(imagesArray[pic]);

            Toast.makeText(MainActivity2.this, "La orientación se modifica a la izquierda.", Toast.LENGTH_SHORT).show();

        });

        // Método del botón para la orientación a la derecha:

        forward.setOnClickListener(view -> {
            right = true;

            iv.setImageResource(imagesArray[pic]);

            Toast.makeText(MainActivity2.this, "La orientación se modifica a la derecha.", Toast.LENGTH_SHORT).show();

        });

    }

}