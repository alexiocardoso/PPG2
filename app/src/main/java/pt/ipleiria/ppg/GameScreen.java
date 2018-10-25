package pt.ipleiria.ppg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import pt.ipleiria.ppg.model.Game;
import pt.ipleiria.ppg.model.Singleton;

public class GameScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        final Intent intent = getIntent();
        final Game gameParaEditar = (Game) intent.getSerializableExtra(MainActivity.PT_IPLEIRIA_PPG_INFO);


        //Buscar Title
        final EditText editTitle = findViewById(R.id.editText_GameTitle);
        //Buscar Descrição
        final EditText editDescription = findViewById(R.id.editText_GameDescription);
        //Buscar Autor
        final EditText editAuthor = findViewById(R.id.editText_GameAuthor);
        //Buscar Duração
        final EditText editDuration = findViewById(R.id.editText_GameDuration);
        //Buscar Data
        final TextView textViewDate = findViewById(R.id.textView_GameEditDate);
        //Buscar Id
        final TextView textViewId = findViewById(R.id.textView_GameId);


        //Buscar botão
        Button button = findViewById(R.id.button_GameScreen);
        if (gameParaEditar != null) {
            //se contacto não for null, modo edit
            button.setText(R.string.edit);
            //preencher Campos
            editTitle.setText(gameParaEditar.getTitle());
            editDescription.setText(gameParaEditar.getDescription());
            editAuthor.setText(gameParaEditar.getAuthor());
            editDuration.setText("" + gameParaEditar.getDuration());
            textViewDate.setText(getString(R.string.lastEditDate) + " " + gameParaEditar.getLastDate().toString());
            textViewId.setText(getString(R.string.uniqueID) + " " + gameParaEditar.getId());
        } else {
            //se contacto for null, modo add
            button.setText(R.string.add);
            textViewDate.setText("");
            textViewId.setText("");
        }

        //Metodo de clicar no botao
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Obter o titulo
                String title = editTitle.getText().toString();
                //Obter a descrição
                String description = editDescription.getText().toString();
                //Obter o autor
                String author = editAuthor.getText().toString();
                //Obter a duração
                String durationAsString = editDuration.getText().toString();
                int duration = Integer.parseInt(durationAsString);

                Game g = new Game(title,description,author,duration);

                //Devolve Jogo antigo
                if (gameParaEditar != null){
                    Singleton.getInstance().getGeneral().editGame(g, gameParaEditar.getTitle());
                }else{
                    Singleton.getInstance().getGeneral().addGame(g);
                }
                finish();
            }
        });
    }
}
