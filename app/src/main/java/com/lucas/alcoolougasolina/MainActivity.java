package com.lucas.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText txtAlcool, txtGasolina;
    private TextView txtResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtAlcool    = findViewById(R.id.txtAlcool);
        txtGasolina  = findViewById(R.id.txtGasolina);
        txtResult    = findViewById(R.id.txtResult);
    }

    public void calcular(View view) {
        //Recuperar digitação
        String precoAlcool = txtAlcool.getText().toString();
        String precoGasolina = txtGasolina.getText().toString();

        //Validação dos campos
        Boolean camposValidados = validarCampos(precoAlcool, precoGasolina);
        if(camposValidados){
            //Convertendo String para números
            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);

            if(valorAlcool < valorGasolina){
                txtResult.setText("Melhor utilizar álcool");
            }else{
                txtResult.setText("Melhor utilizar gasolina");
            }
        }else{
            txtResult.setText("Preencha os campos solicitados");
        }

    }

    public Boolean validarCampos(String pAlcool, String pGasolina){
        Boolean camposValidados = true;

        if(pAlcool == null || pAlcool.equals("")){
            camposValidados=false;
        }else if(pGasolina == null || pGasolina.equals("")){
            camposValidados=false;
        }

        return camposValidados;
    }
}