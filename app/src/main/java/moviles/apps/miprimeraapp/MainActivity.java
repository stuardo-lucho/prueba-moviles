package moviles.apps.miprimeraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView textViewContador = findViewById(R.id.textViewContador);
                String contadorStr = textViewContador.getText().toString();
                int contador = Integer.parseInt(contadorStr);
                contador++;
                Log.d("contador", "" + contador);
                textViewContador.setText(String.valueOf(contador));
            }
        });

        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, "https://www.pucp.edu.pe");

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "La acción no es soportada", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void incrementarContador(View view) {
        TextView textViewContador = findViewById(R.id.textViewContador);
        String contadorStr = textViewContador.getText().toString();
        int contador = Integer.parseInt(contadorStr);
        contador++;
        Log.d("contador", "" + contador);
        textViewContador.setText(String.valueOf(contador));
    }

    public void abrirOtraActivity(View view) {
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("nombre", "Juan");
        intent.putExtra("edad", 20);
        intent.putExtra("curso", new Curso("TEL306"));
        startActivity(intent);
    }



}
