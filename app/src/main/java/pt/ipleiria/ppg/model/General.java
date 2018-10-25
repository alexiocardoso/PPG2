package pt.ipleiria.ppg.model;

import java.io.Serializable;
import java.util.ArrayList;

public class General implements Serializable {
    private ArrayList<Game> games;

    public General(){
        this.games = new ArrayList<>();
    }

    public void addGame(Game game){
        if(containsGame(game.getTitle()))
            throw new RuntimeException("Cannot add Game. Game title already exists.");

        games.add(game);
    }
    //Verifica se titulo já existe
    public boolean containsGame(String title){
        for (Game g: games){
            if(g.getTitle().equalsIgnoreCase(title))
                return true;
        }
        return false;
    }
    public ArrayList<Game> searchGameByTitle(String title) {
        ArrayList<Game> res = new ArrayList<>();
        for (Game g : games) {
            if (g.getTitle().contains(title)) {
                res.add(g);
            }
        }
        return res;
    }

    public ArrayList<Game> getGames(){
        return games;
    }


    public boolean editGame (Game newGame, String title){
        for (Game g : games) {
            if (g.getTitle() == title) {
                g.setTitle(newGame.getTitle());
                g.setDescription(newGame.getDescription());
                g.setAuthor(newGame.getAuthor());
                g.setDuration(newGame.getDuration());

                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String res = "";
        for (Game g : games) {
            res += g + "\n";
        }
        return res;
    }
}
