package br.com.fecapccp.temdetudo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        // Receber o nome do cliente
        Bundle bundle = getIntent().getExtras();
        String clientName = bundle.getString("CLIENT_NAME");

        // Configurar a mensagem de boas-vindas
        TextView textBemVindo = findViewById(R.id.textBemVindo);
        textBemVindo.setText(String.format(getString(R.string.bem_vindo), clientName));

        // Configurar o botão de voltar
        Button btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity3.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}