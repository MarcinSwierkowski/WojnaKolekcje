import java.util.LinkedList;
import java.util.Queue;

public class Gracz {

    private int id;
    private String name;
    private Queue<KartaDoGry> reka = new LinkedList<>();
    private boolean czyWykladaKarte = true;

    public Gracz(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Queue<KartaDoGry> getReka() {
        return reka;
    }

    public void dodajKartę(KartaDoGry karta){
        reka.add(karta);
    }

    public int getId() {
        return id;
    }

    public boolean isCzyWykladaKarte() {
        return czyWykladaKarte;
    }

    public void setCzyWykladaKarte(boolean czyWykladaKarte) {
        this.czyWykladaKarte = czyWykladaKarte;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}