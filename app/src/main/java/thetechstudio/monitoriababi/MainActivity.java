package thetechstudio.monitoriababi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonJogar;
    private Button buttonInstrucao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Aqui fazemos a configuracao dos elementos que sao mostrados na tela.
        buttonInstrucao = (Button)findViewById(R.id.buttonInstrucao);
        buttonJogar = (Button) findViewById(R.id.buttonJogar);

        buttonInstrucao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implemento a acao do botao aqui dentro
                // Para transitar entre telas usamos uma intent
                // Passando como parametro a tela de origem e a tela de destino.
                Intent intent = new Intent(MainActivity.this,InstrucoesActivity.class);

                // Apos configurar a intent passar ela por parametro para o
                // metodo startActivity
                startActivity(intent);
            }
        });

        buttonJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Categorias_Activity.class);
                startActivity(intent);
            }
        });
    }
}
