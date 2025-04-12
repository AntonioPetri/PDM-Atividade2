package br.com.fecapccpv.projeto5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    private RadioGroup radioGroupTamanho, radioGroupPagamento;
    private Button btnFinalizarPedido;
    private double custoTotal;
    private String tamanhoEscolhido, pagamentoEscolhido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);


        radioGroupTamanho = findViewById(R.id.radioGroupTamanho);
        radioGroupPagamento = findViewById(R.id.radioGroupPagamento);
        btnFinalizarPedido = findViewById(R.id.btnFinalizarPedido);

        Bundle bundle = getIntent().getExtras();
        ArrayList<String> saboresSelecionados = bundle.getStringArrayList("SABORES");
        custoTotal = bundle.getDouble("CUSTOTOTAL", 0.0);


        btnFinalizarPedido.setOnClickListener(view -> {
            tamanhoEscolhido = escolherTamaho();
            pagamentoEscolhido = escoherPagamento();

            if (tamanhoEscolhido.isEmpty() || pagamentoEscolhido.isEmpty()) {
                return;
            }

            if(tamanhoEscolhido.equals("Pequena")) custoTotal += 25;
            if(tamanhoEscolhido.equals("Média")) custoTotal += 35;
            if(tamanhoEscolhido.equals("Grande")) custoTotal += 45;

            Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
            intent.putExtra("SABORES", saboresSelecionados);
            intent.putExtra("CUSTOTOTAL", custoTotal);
            intent.putExtra("TAMANHO", tamanhoEscolhido);
            intent.putExtra("PAGAMENTO", pagamentoEscolhido);
            startActivity(intent);
            finish();
        });
    }

    public String escolherTamaho() {
        String tamanho = "";

        int tamanhoId = radioGroupTamanho.getCheckedRadioButtonId();
        if (tamanhoId == R.id.radioPequena) {
            tamanho = "Pequena";
        } else if (tamanhoId == R.id.radioMedia) {
            tamanho = "Média";
        } else if (tamanhoId == R.id.radioGrande) {
            tamanho = "Grande";
        } else {
            Toast.makeText(MainActivity2.this,
                    "Selecione um tamanho", Toast.LENGTH_SHORT).show();
        }
        return tamanho;
    }

    public String escoherPagamento(){
        String pagamento = "";
        int pagamentoId = radioGroupPagamento.getCheckedRadioButtonId();
        if (pagamentoId == R.id.radioDinheiro) {
            pagamento = "Dinheiro";
        } else if (pagamentoId == R.id.radioCartao) {
            pagamento = "Cartão";
        } else {
            Toast.makeText(MainActivity2.this,
                    "Selecione um método de pagamento", Toast.LENGTH_SHORT).show();
        }
        return pagamento;
    }
}