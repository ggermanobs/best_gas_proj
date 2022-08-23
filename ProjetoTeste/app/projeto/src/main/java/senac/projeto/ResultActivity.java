package senac.projeto;

import static android.view.View.*;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ResultActivity extends Activity {
    @SuppressLint("MissingSuperCall")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Intent intent = getIntent();
        String gasolinaEt = intent.getStringExtra(MainActivity.EXTRA_VALOR_GASOLINA);
        String etanolEt = intent.getStringExtra(MainActivity.EXTRA_VALOR_ETANOL);
        String consumo_gasolina = intent.getStringExtra(MainActivity.EXTRA_CONSUMO_GASOLINA);
        String consumo_etanol = intent.getStringExtra(MainActivity.EXTRA_CONSUMO_ETANOL);



        TextView resultado_valor_gasolina = findViewById(R.id.resultado_valor_gasolina);
        TextView resultado_kml_gasolina = findViewById(R.id.resultado_kml_gasolina);
        TextView resultado_valor_etanol = findViewById(R.id.resultado_valor_etanol);
        TextView resultado_kml_etanol = findViewById(R.id.resultado_kml_etanol);
        TextView resultado_consumo = findViewById(R.id.resultado_consumo);
        TextView resultado_abasteca = findViewById(R.id.resultado_abasteca);
        TextView resultado_economia = findViewById(R.id.resultado_economia);

        double valorGasolinaBack = Double.parseDouble(gasolinaEt);
        double valorEtanolBack = Double.parseDouble(etanolEt);
        double consumoGasolinaBack = Double.parseDouble(consumo_gasolina);
        double consumoEtanolBack = Double.parseDouble(consumo_etanol);
        double resultadoConsumoGasolina = valorGasolinaBack / consumoGasolinaBack;
        double resultadoConsumoEtanol = valorEtanolBack / consumoEtanolBack;
        double resultadoConsumo = 0;
        double relacaoCombustivel = (valorEtanolBack / valorGasolinaBack) * 100;

        resultado_valor_gasolina.setText("R$ "+ gasolinaEt);
        resultado_valor_etanol.setText("R$ "+ etanolEt);
        resultado_kml_gasolina.setText("Consumo Gasolina "+ consumo_gasolina);
        resultado_kml_etanol.setText("Consumo Etanol "+ consumo_etanol);
        resultado_consumo.setText("Relação Etanol / Gasolina");


        resultado_consumo.setText(
                String.format("Relação Etanol/Gasolina %.2f", relacaoCombustivel) + ("%") +
                        String.format("\nGasto com Gasolina R$%.2f", resultadoConsumoGasolina) +
                        String.format("\nGasto com Etanol R$%.2f", resultadoConsumoEtanol));

        if (resultadoConsumoGasolina < resultadoConsumoEtanol) {
            resultadoConsumo = resultadoConsumoEtanol - resultadoConsumoGasolina;
            resultado_economia.setText(String.format("Economia de R$%.2f", resultadoConsumo) + " por litro");
        } else {
            resultadoConsumo = resultadoConsumoGasolina - resultadoConsumoEtanol;
            resultado_economia.setText(String.format("Economia de R$%.2f", resultadoConsumo) + " por litro");
        }

        if(relacaoCombustivel >= 70) {
            resultado_abasteca.setText("Abasteça com Gasolina");
        } else {
            resultado_abasteca.setText("Abasteça com Etanol");
        }

        Button backButton = findViewById(R.id.voltar_button);
        backButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                ResultActivity.super.onBackPressed();
            }
        });
}
}

