package moviles.apps.miprimeraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setTitle("Message Activity");
        setContentView(R.layout.activity_message);

        Button b = findViewById(R.id.buttonGuardar);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                EditText inputText = findViewById(R.id.editText);
                String text = inputText.getText().toString();
                intent.putExtra("nombreUsuario",text);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}
