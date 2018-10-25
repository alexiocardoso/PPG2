package pt.ipleiria.ppg.model;

public class Singleton {
    private static final Singleton ourInstance = new Singleton();

    public static Singleton getInstance() {
        return ourInstance;
    }

    private General general;

    private Singleton() {
        this.general = new General();
    }

    public General getGeneral(){
        return general;
    }

    public void setGeneral(General general){
        this.general = general;
    }
}
