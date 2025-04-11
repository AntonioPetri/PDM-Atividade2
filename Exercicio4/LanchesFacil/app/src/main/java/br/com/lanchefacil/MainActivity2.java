package br.com.lanchefacil;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton rbPedido1, rbPedido2, rbPedido3, rbPedido4;
    private Button btnFazer;
    private String pedidoFeito;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        radioGroup = findViewById(R.id.radioGroup);

        btnFazer = findViewById(R.id.btnFazer);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        btnFazer.setOnClickListener(view -> {
            if (verificarPedido()) {
                Intent intent = new Intent(this, MainActivity3.class);
                intent.putExtra("Pedido", pedidoFeito);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Por favor, selecione um pedido", Toast.LENGTH_SHORT).show();
            }

        });

    }

    public boolean verificarPedido() {
        int selectedId = radioGroup.getCheckedRadioButtonId();

        if (selectedId == -1) {
            return false;
        } else {
            RadioButton radioButton = findViewById(selectedId);
            pedidoFeito = radioButton.getText().toString();
            return true;
        }
    }
}