package br.com.fecapccp.projeto1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    // Variavel
    private CheckBox cbArroz, cbLeite, cbCarne, cbFeijao, cbRefrigerante;
    private Button btnTotal;
    private TextView textResultado;

    // Valores de cada um
    private final double PRECO_ARROZ = 2.69;
    private final double PRECO_LEITE = 2.70;
    private final double PRECO_CARNE = 16.70;
    private final double PRECO_FEIJAO = 3.38;
    private final double PRECO_REFRIGERANTE = 3.00;

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

        cbArroz = findViewById(R.id.cbArroz);
        cbLeite = findViewById(R.id.cbLeite);
        cbCarne = findViewById(R.id.cbCarne);
        cbFeijao = findViewById(R.id.cbFeijao);
        cbRefrigerante = findViewById(R.id.cbRefrigerante);

        btnTotal = findViewById(R.id.btnTotal);

        textResultado = findViewById(R.id.textResultado);


        btnTotal.setOnClickListener( view -> {
            calcularTotal();
        });
    }

    private void calcularTotal() {
        double total = 0.0;

        if (cbArroz.isChecked()) {
            total += PRECO_ARROZ;
        }
        if (cbLeite.isChecked()) {
            total += PRECO_LEITE;
        }
        if (cbCarne.isChecked()) {
            total += PRECO_CARNE;
        }
        if (cbFeijao.isChecked()) {
            total += PRECO_FEIJAO;
        }
        if (cbRefrigerante.isChecked()) {
            total += PRECO_REFRIGERANTE;
        }

        textResultado.setText(String.format("Total da compra: R$ %.2f", total));
    }
}