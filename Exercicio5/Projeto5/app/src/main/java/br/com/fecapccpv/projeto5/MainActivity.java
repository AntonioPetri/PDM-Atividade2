package br.com.fecapccpv.projeto5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkCalabresa, checkMarguerita, checkPortuguesa;
    private Button btnProximoTipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        checkCalabresa = findViewById(R.id.checkCalabresa);
        checkMarguerita = findViewById(R.id.checkMarguerita);
        checkPortuguesa = findViewById(R.id.checkPortuguesa);
        btnProximoTipo = findViewById(R.id.btnProximoTipo);

        btnProximoTipo.setOnClickListener(view -> {
            ArrayList<String> saboresSelecionados = onClick();
            double custoTotal = calcularCusto();
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("SABORES", saboresSelecionados);
            intent.putExtra("CUSTOTOTAL", custoTotal);
            startActivity(intent);
        });

    }

    public ArrayList<String> onClick() {
        ArrayList<String> saboresSelecionados = new ArrayList<>();

        if (checkCalabresa.isChecked()) saboresSelecionados.add("Calabresa");
        if (checkMarguerita.isChecked()) saboresSelecionados.add("Marguerita");
        if (checkPortuguesa.isChecked()) saboresSelecionados.add("Portuguesa");

        if (saboresSelecionados.isEmpty()) {
            Toast.makeText(MainActivity.this,
                    "Selecione pelo menos um sabor", Toast.LENGTH_SHORT).show();
        }
        return saboresSelecionados;
    }

    public double calcularCusto(){
        double custo = 0;
        if (checkCalabresa.isChecked()) custo += 15;
        if (checkMarguerita.isChecked()) custo += 20;
        if (checkPortuguesa.isChecked()) custo += 25;

        return custo;
    }
}