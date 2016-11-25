package thetechstudio.monitoriababi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class ConsultaBanco extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "BancoQuestoes.db";
    private static final String TABLE_QUESTAO = "questoes";
    //private static final String TABLE_RANKING = "ranking";

    private static final int DATABASE_VERSION = 1;

    // Criando as TAGS para imprimir o Log de cada operação
    private static final String TAG_D = "DELETAR REGISTRO";
    private static final String TAG_I = "INSERIR REGISTRO";
    private static final String TAG_S = "SELECIONAR REGISTROS";

    public ConsultaBanco(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql_questao = "CREATE TABLE " + TABLE_QUESTAO
                + "(id INTEGER PRIMARY KEY, "
                + "enunciado TEXT, "
                + "resposta TEXT, "
                + "alternativaA TEXT, "
                + "alternativaB TEXT, "
                + "alternativaC TEXT, "
                + "alternativaD TEXT, "
                + "nivel INTEGER,"
                + "pontuacao INTEGER);";

        String sql_ranking = "CREATE TABLE " + TABLE_QUESTAO
                + "(id INTEGER PRIMARY KEY, "
                + "nome_jogador TEXT, "
                + "pontuacao INTEGER);";

        sqLiteDatabase.execSQL(sql_questao);
//        sqLiteDatabase.execSQL(sql_ranking);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public ArrayList<Questao> consultarQuestoes() {

        ArrayList<Questao> listaQuestoes = new ArrayList<Questao>();

        String sql = "SELECT * FROM " + TABLE_QUESTAO;

        Cursor cursor = getReadableDatabase().rawQuery(sql, null);

        while (cursor.moveToNext()) {

            Questao questao = new Questao();

            questao.setId(cursor.getInt(0));
            questao.setEnunciado(cursor.getString(1));
            questao.setResposta(cursor.getString(2));
            questao.setAlternativaA(cursor.getString(3));
            questao.setAlternativaB(cursor.getString(4));
            questao.setAlternativaC(cursor.getString(5));
            questao.setAlternativaD(cursor.getString(6));
            questao.setNivel(cursor.getInt(7));
            questao.setPontuacao(cursor.getInt(8));

            listaQuestoes.add(questao);

            Log.i(TAG_S, "O registro de id: "+questao.getId()+" foi selecionado");
        }

        return listaQuestoes;
    }

    public void addQuestoes(Questao questoes){

        ContentValues contentValues = new ContentValues();

        contentValues.put("enunciado", questoes.getEnunciado());
        contentValues.put("resposta", questoes.getResposta());
        contentValues.put("alternativaA", questoes.getAlternativaA());
        contentValues.put("alternativaB", questoes.getAlternativaB());
        contentValues.put("alternativaC", questoes.getAlternativaC());
        contentValues.put("alternativaD", questoes.getAlternativaD());
        contentValues.put("nivel", questoes.getNivel());
        contentValues.put("pontuacao", questoes.getPontuacao());


        getWritableDatabase().insert(TABLE_QUESTAO, null, contentValues);

        Log.i(TAG_I, "O registro de id: "+questoes.getId()+" foi inserido com sucesso");

    }

    // OK - Remover registro de questoes
    public void removerAluno(Questao questoes){
        Integer id = questoes.getId();
        String [] args = {id.toString()};

        getWritableDatabase().delete(TABLE_QUESTAO,"id=?",args);

        Log.i(TAG_D, "O registro de id: "+args+" foi deletado com sucesso");

    }

    // Criar carga de dados no banco.
    public void loadDataBase(){

        // Questao 1
        Questao questoes = new Questao();
        questoes.setEnunciado(" realizou-se em agosto de 2016 , os Jogos Olímpicos do Rio de Janeiro. Esse grande congraçamento entre os povos ocorre de quatro em quatro anos. As Olimpíadas de 2008 ocorreram em Londres, e as de 2020 ocorrerão em:");
        questoes.setResposta("D");
        questoes.setAlternativaA("Estocolmo");
        questoes.setAlternativaB("Moscou");
        questoes.setAlternativaC("Paris.");
        questoes.setAlternativaD("Tóquio");
        questoes.setNivel(1);
        questoes.setPontuacao(25);

        // Questao 2
        Questao questoes2 = new Questao();
        questoes2.setEnunciado("Facebook, Orkut, Linkedin são alguns dos nomes que se tornaram presentes no nosso dia a dia. Com milhares de seguidores, são objeto de grande interesse de pesquisadores que buscam entender sua influência no comportamento das pessoas.Facebook, Orkut, Linkedin são?");
        questoes2.setResposta("A");
        questoes2.setAlternativaA("Redes sociais");
        questoes2.setAlternativaB("Servidores de e-mail");
        questoes2.setAlternativaC("Mecanismos de busca");
        questoes2.setAlternativaD("Sistemas de computação");
        questoes2.setNivel(1);
        questoes2.setPontuacao(25);

        // Questao 3
        Questao questoes3 = new Questao();
        questoes3.setEnunciado("A seguinte modalidade esportiva não está incluída entre as competições dos Jogos Olímpicos de 2016?");
        questoes3.setResposta("D");
        questoes3.setAlternativaA("golfe");
        questoes3.setAlternativaB("taekwondo");
        questoes3.setAlternativaC("badminton");
        questoes3.setAlternativaD("futebol de salão");
        questoes3.setNivel(1);
        questoes3.setPontuacao(25);
        
        // Questao 4
        Questao questoes4 = new Questao();
        questoes4.setEnunciado("O Índice de Desenvolvimento Humano (IDH) constitui-se um indicador sintético de avaliação da qualidade de vida de uma determinada população. Fazem parte do IDH três elementos fundamentais de análise?");
        questoes4.setResposta("B");
        questoes4.setAlternativaA("Saúde, Cultura e Renda");
        questoes4.setAlternativaB("Renda, Saúde e Educação.");
        questoes4.setAlternativaC("Educação, Economia e Lazer.");
        questoes4.setAlternativaD("Educação, Segurança e Saúde.");
        questoes4.setNivel(1);
        questoes4.setPontuacao(25);

        // Questao 5
        Questao questoes5 = new Questao();
        questoes5.setEnunciado("O Índice de Desenvolvimento Humano (IDH) constitui-se um indicador sintético de avaliação da qualidade de vida de uma determinada população. Fazem parte do IDH três elementos fundamentais de análise?");
        questoes5.setResposta("B");
        questoes5.setAlternativaA("Saúde, Cultura e Renda");
        questoes5.setAlternativaB("Renda, Saúde e Educação.");
        questoes5.setAlternativaC("Educação, Economia e Lazer.");
        questoes5.setAlternativaD("Educação, Segurança e Saúde.");
        questoes5.setNivel(1);
        questoes5.setPontuacao(25);

        addQuestoes(questoes);
        addQuestoes(questoes2);
        addQuestoes(questoes3);
        addQuestoes(questoes4);
        addQuestoes(questoes5);
    }

}
