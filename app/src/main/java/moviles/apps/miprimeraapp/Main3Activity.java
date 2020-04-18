package moviles.apps.miprimeraapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Main Activity");
        setContentView(R.layout.activity_main3);

        if (savedInstanceState != null) {
            String text = savedInstanceState.getString("texto");
            if (text != null) {
                TextView textView = findViewById(R.id.textView8);
                textView.setText(text);
            }
        }


        Button button = findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Main3Activity.this,
                        MessageActivity.class);
                int requestCode = 1;
                startActivityForResult(intent, requestCode);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    @Nullable Intent data) {

        if (requestCode == 1 && resultCode == RESULT_OK) {

            String dataFromMessageActivity = data.getStringExtra("nombreUsuario");

            TextView textView = findViewById(R.id.textView8);
            String texto = textView.getText().toString();

            textView.setText(String.valueOf(texto + dataFromMessageActivity));
        }

    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        TextView textView = findViewById(R.id.textView8);
        String texto = textView.getText().toString();

        if (!texto.equals(getString(R.string.texto_text_view_8))) {
            outState.putString("texto", texto);
        }
    }
}
