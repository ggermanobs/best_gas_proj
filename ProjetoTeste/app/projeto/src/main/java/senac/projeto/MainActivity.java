package senac.projeto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.TokenWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MainActivity extends Activity {
    public static final String EXTRA_VALOR_GASOLINA = "VALOR_GASOLINA";
    public static final String EXTRA_VALOR_ETANOL = "VALOR_ETANOL";
    public static final String EXTRA_CONSUMO_GASOLINA = "CONSUMO_GASOLINA";
    public static final String EXTRA_CONSUMO_ETANOL = "CONSUMO_ETANOL";


    private Button button_calcular;
    private EditText gasolinaEt;
    private EditText etanolEt;
    private EditText consumo_gasolina;
    private EditText consumo_etanol;

    @Override
        protected void  onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gasolinaEt = findViewById(R.id.gasolinaEt);
        etanolEt = findViewById(R.id.etanolEt);
        consumo_etanol = findViewById(R.id.consumo_etanol);
        consumo_gasolina = findViewById(R.id.consumo_gasolina);
        button_calcular = findViewById(R.id.button_calcular);
        button_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeToResultScreen();
            }
        });
    };
        private void changeToResultScreen() {
            Intent intent = new Intent(this,ResultActivity.class);
            EditText gasolinaEt = (EditText) findViewById(R.id.gasolinaEt);
            EditText etanolEt = (EditText) findViewById(R.id.etanolEt);
            intent.putExtra(EXTRA_VALOR_GASOLINA, gasolinaEt.getText().toString());
            intent.putExtra(EXTRA_VALOR_ETANOL,etanolEt.getText().toString());
            EditText consumo_etanol = (EditText) findViewById(R.id.consumo_etanol);
            EditText consumo_gasolina = (EditText) findViewById(R.id.consumo_gasolina);
            intent.putExtra(EXTRA_CONSUMO_ETANOL, consumo_etanol.getText().toString());
            intent.putExtra(EXTRA_CONSUMO_GASOLINA,consumo_gasolina.getText().toString());

            startActivity(intent);


        }
}
