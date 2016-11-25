package thetechstudio.monitoriababi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InstrucoesActivity extends AppCompatActivity {

    private TextView textoInstrucoes;
    private Button buttonvoltarMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrucoes);
        // MUDAR TELA PARA MENU

        buttonvoltarMenu = (Button)findViewById(R.id.button);
        buttonvoltarMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent (InstrucoesActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
            //intent para mudar tela para menu


        textoInstrucoes = (TextView) findViewById(R.id.texto_instrucoes);

        String msg = "";
        String texto = textoInstrucoes.getText().toString();

        String novoTexto = msg + texto;

        textoInstrucoes.setText(novoTexto);
    }

}
