package thetechstudio.monitoriababi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Categorias_Activity extends AppCompatActivity {

    private CheckBox checkBoxMatematica;
    private CheckBox checkBoxPortugues;
    private CheckBox checkBoxCienciasNat;
    private CheckBox checkBoxCienciasHum;
    private CheckBox checkBoxAleatorio;

    private Button buttonConfirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias_);

        checkBoxPortugues = (CheckBox) findViewById(R.id.checkbox_lingua_por);
        checkBoxMatematica = (CheckBox) findViewById(R.id.checkbox_matematica);
        checkBoxCienciasNat = (CheckBox) findViewById(R.id.checkbox_ciencias_nat);
        checkBoxCienciasHum = (CheckBox) findViewById(R.id.checkbox_ciencias_hum);
        checkBoxAleatorio = (CheckBox) findViewById(R.id.checkbox_aleatorio);


        buttonConfirmar = (Button) findViewById(R.id.Button_Confirmar);

        buttonConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int opcaoSelecionada = 0;

                if(checkBoxPortugues.isChecked()){
                    opcaoSelecionada++;
                }
                if(checkBoxMatematica.isChecked()) {
                    opcaoSelecionada++;
                }
                if(checkBoxCienciasNat.isChecked()){
                    opcaoSelecionada++;
                }
                if(checkBoxCienciasHum.isChecked()){
                    opcaoSelecionada++;
                }
                if(checkBoxAleatorio.isChecked()){
                    opcaoSelecionada++;
                }
                // TODO: fazer isso para os demais checkbox
                // somente para mostrar mensagem;
                if(opcaoSelecionada > 1){
                    //Usa este elemento para mostrar uma mensagem rapida na interface
                    Toast.makeText(getApplicationContext(), "Voce deve selecionar somente uma opcao", Toast.LENGTH_LONG).show();
                    checkBoxPortugues.setChecked(false);
                    checkBoxMatematica.setChecked(false);
                    checkBoxCienciasNat.setChecked(false);
                    checkBoxCienciasHum.setChecked(false);
                    checkBoxAleatorio.setChecked(false);
                }else{
                    Intent intent = new Intent(Categorias_Activity.this, Questoes_Activity.class);
                    startActivity(intent);
                }
            }
        });




    }
}
