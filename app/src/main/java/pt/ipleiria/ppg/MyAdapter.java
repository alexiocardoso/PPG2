package pt.ipleiria.ppg;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import pt.ipleiria.ppg.model.Game;

public class MyAdapter extends ArrayAdapter<Game> {
    private final Context context;
    private ArrayList<Game> games;

    public MyAdapter(Context context, ArrayList<Game> games) {
        super(context, R.layout.item_game, games);
        this.context = context;
        this.games = games;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_game, parent, false);
        }

        Game game = games.get(position);
        TextView name = convertView.findViewById(R.id.textView_GameTitle);
        name.setText(game.getTitle());
        TextView phone = convertView.findViewById(R.id.textView_GameDescription);
        phone.setText(game.getDescription());

        return convertView;
    }
}
