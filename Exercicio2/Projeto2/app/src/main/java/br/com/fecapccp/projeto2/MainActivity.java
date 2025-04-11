package br.com.fecapccp.projeto2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private RadioGroup rgPorcentagens;
    private RadioButton rb40, rb45, rb50;
    private TextView textResultado;
    private Button btnMostrar;
    private EditText etSalario;
    private Boolean valido;
    private double salario, novoSalario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rgPorcentagens = findViewById(R.id.rgPorcentagens);

        rb40 = findViewById(R.id.rb40);
        rb45 = findViewById(R.id.rb45);
        rb50 = findViewById(R.id.rb50);

        textResultado = findViewById(R.id.textResultado);

        btnMostrar = findViewById(R.id.btnMostrar);

        etSalario = findViewById(R.id.etSalario);


        btnMostrar.setOnClickListener(view -> {
            valido = validarCampo(etSalario);
            if (valido){
                calcularAumentoSalarial();
            }
        });

    }

    public boolean validarCampo(EditText editText) {
        String texto = editText.getText().toString().trim();

        if (texto.isEmpty()) {
            editText.setError("Campo não pode estar vazio!");
            return false;
        }
        try {
            double valor = Double.parseDouble(texto);
            editText.setError(null);
            return true;
        } catch (NumberFormatException e) {
            editText.setError("Digite um número válido (ex: 75 ou 1.75)!");
            return false;
        }
    }

    private void calcularAumentoSalarial() {
        String textSalario = etSalario.getText().toString().trim();
        salario = Double.parseDouble(textSalario);
        String formatado;

        int selectedId = rgPorcentagens.getCheckedRadioButtonId();

        if (selectedId == R.id.rb40) {
            novoSalario = salario * 1.4;
            formatado = String.format("%.2f", novoSalario);
            textResultado.setText(formatado);
        } else if (selectedId == R.id.rb45) {
            novoSalario = salario * 1.45;
            formatado = String.format("%.2f", novoSalario);
            textResultado.setText(formatado);
        } else if (selectedId == R.id.rb50) {
            novoSalario = salario * 1.5;
            formatado = String.format("%.2f", novoSalario);
            textResultado.setText(formatado);
        }
    }

}