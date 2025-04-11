package br.com.fecapccp.temdetudo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button btnRegistro = findViewById(R.id.btnRegistro);
        btnRegistro.setOnClickListener(view -> {
            // Pega o nome e leva para a próxima tela
            EditText nomeEditText = findViewById(R.id.nomeEditText);
            String name = nomeEditText.getText().toString().trim();
            if (!name.isEmpty()) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                intent.putExtra("CLIENT_NAME", name);
                startActivity(intent);
                finish();
            } else {
                nomeEditText.setError("Por favor, insira seu nome");
            }
        });

    }
}