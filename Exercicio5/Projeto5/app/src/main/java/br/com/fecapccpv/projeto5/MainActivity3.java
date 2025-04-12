package br.com.fecapccpv.projeto5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    private TextView txtResumoPedido;
    private Button btnNovoPedido;
    private double custoTotal;
    private String tamanhoEscolhido, pagamentoEscolhido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        txtResumoPedido = findViewById(R.id.txtResumoPedido);
        btnNovoPedido = findViewById(R.id.btnNovoPedido);

        Bundle bundle = getIntent().getExtras();
        ArrayList<String> saboresSelecionados = bundle.getStringArrayList("SABORES");
        custoTotal = bundle.getDouble("CUSTOTOTAL", 0.0);
        tamanhoEscolhido = bundle.getString("TAMANHO");
        pagamentoEscolhido = bundle.getString("PAGAMENTO");


        String resumo = "Resumo do Pedido:\n\n" +
                "Sabores: " + String.join(", ", saboresSelecionados) + "\n" +
                "Tamanho: " + tamanhoEscolhido + "\n" +
                "Pagamento: " + pagamentoEscolhido + "\n" +
                "Valor Total: " + custoTotal;

        txtResumoPedido.setText(resumo);

        btnNovoPedido.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity3.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

    }
}