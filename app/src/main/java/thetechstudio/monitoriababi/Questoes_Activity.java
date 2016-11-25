package thetechstudio.monitoriababi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Questoes_Activity extends AppCompatActivity {

    private TextView TextEnunciado;
    private TextView IntID;
    private TextView TextPontuacao;
    private RadioButton Resposta1;
    private RadioButton Resposta2;
    private RadioButton Resposta3;
    private RadioButton Resposta4;

    private Button buttonConfirmar;
    private String opcaoSelecionada;
    private Questao questaoAtual;

    //TODO: somente a titulo de exemplo.
    private ArrayList<Questao> questoes;
    private int quantidadeAcertos = 0;
    private int PontosAdquiridos = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questoes_);

        IntID = (TextView) findViewById(R.id.textView_id_questao);
        TextEnunciado = (TextView) findViewById(R.id.TituloQuestao);
        Resposta1 = (RadioButton) findViewById(R.id.Button_Resposta01);
        Resposta2 = (RadioButton) findViewById(R.id.Button_Resposta02);
        Resposta3 = (RadioButton) findViewById(R.id.Button_Resposta03);
        Resposta4 = (RadioButton) findViewById(R.id.Button_Resposta04);
        TextPontuacao=(TextView) findViewById(R.id.Text_PontuacaoAtual);
        buttonConfirmar = (Button) findViewById(R.id.button_confirmar);

        ConsultaBanco ListaQuestoes = new ConsultaBanco(this);
        ListaQuestoes.loadDataBase();

        // TODO: Criar a repeticao para sortear questoes
        questoes = ListaQuestoes.consultarQuestoes();
        sortearQuestoes();

        buttonConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //VERIFICAR SE ESTA COM RESPOSTA MARCADA.
                if(Resposta1.isChecked()==false&&Resposta2.isChecked()==false&&Resposta3.isChecked()==false&&Resposta4.isChecked()==false){
                    String Mensagem2="Selecione uma opcao.";
                    Toast.makeText(getApplication(), Mensagem2, Toast.LENGTH_LONG).show();
                }else{
                    corrigirQuestaoAtual();
                }

            }
        });
    }

    private void sortearQuestoes() {
        Random random = new Random();
        int numeroQuestao = random.nextInt(questoes.size());
        questaoAtual = questoes.get(numeroQuestao);
        visualizarQuestao(questaoAtual);
    }

    private void corrigirQuestaoAtual() {
        if (Resposta1.isChecked()) {
            opcaoSelecionada = "A";
            Resposta1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Resposta2.setChecked(false);
                    Resposta3.setChecked(false);
                    Resposta4.setChecked(false);

                }
            });
        }

        if (Resposta2.isChecked()) {
            opcaoSelecionada = "B";
            Resposta2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Resposta1.setChecked(false);
                    Resposta3.setChecked(false);
                    Resposta4.setChecked(false);


                }
            });

        }
        if (Resposta3.isChecked()) {
            opcaoSelecionada = "C";
            Resposta3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                     Resposta1.setChecked(false);
                     Resposta2.setChecked(false);
                     Resposta4.setChecked(false);


                }

            });
        }

        if (Resposta4.isChecked()) {
            opcaoSelecionada = "D";
            Resposta4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Resposta1.setChecked(false);
                    Resposta2.setChecked(false);
                    Resposta3.setChecked(false);


                }

            });

        }

        String mensagem = null;

        if (opcaoSelecionada.equals(questaoAtual.getResposta())) {
            mensagem = "ACERTOU MISERAVI. Ganhou " + questaoAtual.getPontuacao() + " pontos";
            sortearQuestoes();
            PontosAdquiridos=PontosAdquiridos+questaoAtual.getPontuacao();
            quantidadeAcertos++;
            Resposta1.setChecked(false);
            Resposta2.setChecked(false);
            Resposta3.setChecked(false);
            Resposta4.setChecked(false);
        } else {
            mensagem = "ERROU MISERAVI. Perdeu " + 5 + " pontos";
            PontosAdquiridos=PontosAdquiridos-5;
            sortearQuestoes();
            ;
            Resposta1.setChecked(false);
            Resposta2.setChecked(false);
            Resposta3.setChecked(false);
            Resposta4.setChecked(false);
        }

        Toast.makeText(getApplication(), mensagem, Toast.LENGTH_LONG).show();

        // Retira a selecao dos RadioButton

    }


    public void visualizarQuestao(Questao questao) {
        IntID.setText("Questao " + questao.getId());
        TextEnunciado.setText(questao.getEnunciado());
        Resposta1.setText(questao.getAlternativaA());
        Resposta2.setText(questao.getAlternativaB());
        Resposta3.setText(questao.getAlternativaC());
        Resposta4.setText(questao.getAlternativaD());
        TextPontuacao.setText( "Pontos: "+PontosAdquiridos);
    }
}