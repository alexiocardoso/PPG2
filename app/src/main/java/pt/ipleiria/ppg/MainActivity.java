package pt.ipleiria.ppg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import pt.ipleiria.ppg.model.Game;
import pt.ipleiria.ppg.model.General;
import pt.ipleiria.ppg.model.Singleton;
import pt.ipleiria.ppg.model.Task;


public class MainActivity extends AppCompatActivity {

    public static final String PT_IPLEIRIA_PPG_INFO = "pt.ipleiria.ppg.INFO";
    public static final int REQUEST_CODE_ADD = 1;
    public static final String PT_IPLEIRIA_PPG_GAME = "pt.ipleiria.ppg.Game";
    public static final int REQUEST_CODE_EDIT = 2;
    private ListView listView;
    private ArrayAdapter<Game> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //teste
//        Game g1 = new Game("Teste1", "Castelo", "Alberto", 180);
//        Game g2 = new Game("Teste2", "Capela", "Alberto", 60);
//        Game g3 = new Game("Teste3", "Cemitério", "Gervásio", 120);
//        Game g4 = new Game("Teste4", "Tribunal", "Gervásio", 240);

//        Task t1= new Task("Porta", "Bater à porta", 5, 133,1);
//        Task t2= new Task("Carro", "Abre o Carro", 3, 198,2);
//        Task t3= new Task("Chão", "Cai no chão", 2, 112,3);
//        Task t4= new Task("Tecto", "Olha para o tecto", 4, 103,4);
//
//        g1.addTask(t1);
//        g1.addTask(t2);
//        g2.addTask(t3);
//        g3.addTask(t1);
//        g3.addTask(t4);
//        g4.addTask(t1);

//        Singleton.getInstance().getGeneral().addGame(g1);
//        Singleton.getInstance().getGeneral().addGame(g2);
//        Singleton.getInstance().getGeneral().addGame(g3);
//        Singleton.getInstance().getGeneral().addGame(g4);


        listView = findViewById(R.id.listView_Games);
        adapter = new MyAdapter(this, Singleton.getInstance().getGeneral().getGames());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Game game = (Game) parent.getItemAtPosition(position);
                Intent i = new Intent(MainActivity.this, GameScreen.class);
                i.putExtra(PT_IPLEIRIA_PPG_INFO, game);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void onClick_AddItem(MenuItem item) {
        Intent i = new Intent(this, GameScreen.class);
        i.putExtra(PT_IPLEIRIA_PPG_GAME, Singleton.getInstance().getGeneral().getGames());
        startActivity(i);

    }
    public void onClick_SearchItem(MenuItem item) {
        Intent i = new Intent(this, SearchScreen.class);
        i.putExtra(PT_IPLEIRIA_PPG_GAME, Singleton.getInstance().getGeneral().getGames());
        startActivity(i);

    }

    @Override
    protected void onResume() {
        adapter.notifyDataSetChanged();
        super.onResume();
    }
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == REQUEST_CODE_ADD) {
//            if (resultCode == RESULT_OK) {
//                //obter contacto
//                //Game game = (Game) data.getSerializableExtra(GameScreen.EXTRA_CONTACT);
//                try {
//                    //Singleton.getInstance().getAgenda().addContact(contact);
//                    adapter.notifyDataSetChanged();
//                } catch (RuntimeException e) {
//                    e.printStackTrace();
//                    new AlertDialog.Builder(this).setMessage(e.getMessage()).show();
//                }
//            }
//        }
//    }
}

