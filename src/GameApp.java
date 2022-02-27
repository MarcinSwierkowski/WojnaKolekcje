// Gra wg nastepujących zasad:
// - rodzajemy potasowaną talie kart (52-karty) w kółko dla x-graczy od 2-52
// - kazdy gracz ma swoją kolejke kart może wyciągać tylko z przodu i wkładać zdobyte karty z tyłu kolejki
// - wszyscy gracze mający przynajmniej 1 karte wyrzucają karte na stół
// - z grających kart najwyższa zabiera wszystkie karty ze stołu
// - chyba ze jest więcej najwyzszych kart , wtedy WOJNA
// - w wojnie karty uczestniczą tylko ci którzy mieli najwyzsze równe sobie karty
// - dokładają karte nie uczestniczącą w wojnie tzw strata wojenna
// - i dokładaja karte decydująca o wygranej w wojnie
// - jesli znowu wojna ... wsród uczestników wojny .... to rekurencja
// - jesli nie to najwyzsza karta bierze pule ze stołu i od nowa

import java.util.*;

public class GameApp {

    static final int liczbaGraczy = SingletonConfig.getInstance().getLiczbaGraczy();
    static int liczbaPrzegranych = 0;

    public static void main(String[] args) {

        List<KartaDoGry> aktualnaTalia = SingletonConfig.getInstance().getTalia();

        Collections.shuffle(aktualnaTalia); // tasowanie

        List<Gracz> gracze = new ArrayList<>();
        for (int i = 0; i < liczbaGraczy; i++) {
            gracze.add(new Gracz(i, "Gracz_" + (i+1)));
        }

        rozdajKarty(gracze, aktualnaTalia);

        for (int i = 0; i < liczbaGraczy; i++) {
            System.out.println(gracze.get(i).getName()+" "+gracze.get(i).getReka());
        }



        Map<Integer, KartaDoGry> map = new TreeMap<>();
        List<KartaDoGry> rozdanie = new ArrayList<>();

        while (liczbaPrzegranych <liczbaGraczy-1 && rozdanie.size()!=52){

            sprawdzIluPrzegranych(gracze);
            wylosujKarte(map, rozdanie, gracze);

            int sumaKart=0;
            for (int i = 0; i < liczbaGraczy; i++) {

                System.out.println(gracze.get(i).getName()+" "+gracze.get(i).getReka());
                sumaKart=sumaKart+gracze.get(i).getReka().size();
            }
            System.out.println("Suma kart u graczy :"+sumaKart);

            if(rozdanie.size()==52) System.out.println("Gra nierozszczygnięta !!!!"); // nieprawdopodobne ale jednak :) gracze musieli by miec karty po kolei i o takiej samej wartosci
        }
    }


    private static void wylosujKarte(Map<Integer, KartaDoGry> map, List<KartaDoGry> rozdanie, List<Gracz> gracze) {
        int iluZwyciezcow;
        int indexZwyciezcy =1000;
        map.clear();
        for (int i = 0; i < liczbaGraczy; i++) {
            if (gracze.get(i).getReka().size() > 0 && gracze.get(i).isCzyWykladaKarte()) {
                map.put(gracze.get(i).getId(), gracze.get(i).getReka().peek());   // map - analiza
                rozdanie.add(gracze.get(i).getReka().poll());                     // rozdanie - karty w grze
            }
        }

        sprawdzIluPrzegranych(gracze);


        if(map.size()>1) {
            KartaDoGry maxValue = (Collections.max(map.values()));      // map najwieksza karta w grze

            iluZwyciezcow = 0;
            // sprawdzam czy w grze sa jeszcze inne najwieksze karty
            for (Map.Entry<Integer, KartaDoGry> entry :
                    map.entrySet()) {
                if (entry.getValue().getFigura().getMocFigury() == maxValue.getFigura().getMocFigury()) {
                    iluZwyciezcow++;
                    indexZwyciezcy = entry.getKey();
                }
            }
            // jesli są to ustawiam 'wykłada karte' na true tylko dla grających w wojnie
            // tu  muszę zawsze ustawiać wszystkivh do wykłądania kart więc odwrotnośc w logice
            // wyłącze możliwośc wykładania kart graczom nie uczestniczącym w wojnie
            if (iluZwyciezcow > 1) {
                for (Map.Entry<Integer, KartaDoGry> entry :
                        map.entrySet()) {
                    if (entry.getValue().getFigura().getMocFigury() != maxValue.getFigura().getMocFigury()) {
                        gracze.get(entry.getKey()).setCzyWykladaKarte(false);
                    }
                }
                System.out.println("WOJNA!!!");
                // wlożenie kart wojennych do puli, jesli gracz nie może bo nie ma karty na wyłożenie konczy grę, skoro tu dotarł ma przynajmniej 1 karte
                for (int i = 0; i < liczbaGraczy; i++) {
                    if (gracze.get(i).getReka().size() > 0 && gracze.get(i).isCzyWykladaKarte()) {
                        rozdanie.add(gracze.get(i).getReka().poll());
                    }
                }
                wylosujKarte(map, rozdanie, gracze);     //rekurencja :)
            }
            zwyciezcaZabieraKarty(gracze, rozdanie, indexZwyciezcy);
            sprawdzIluPrzegranych(gracze);
        }
    }


    private static void zwyciezcaZabieraKarty(List<Gracz> gracze, List<KartaDoGry> pula, int winner) {

        System.out.println(gracze.get(winner).getName() + " zabiera karty " + pula + "-" + pula.size());
        gracze.get(winner).getReka().addAll(pula);
        pula.clear();

        for (int i = 0; i < liczbaGraczy; i++) {
            gracze.get(i).setCzyWykladaKarte(true);
        }
    }


    private static void rozdajKarty(List<Gracz> gracze, List<KartaDoGry> talia) {
        int licznik = 0;
        do {
            gracze.get(licznik % liczbaGraczy).dodajKartę(talia.get(licznik));
            licznik++;
        } while (licznik < 52);
    }

    private static void sprawdzIluPrzegranych(List<Gracz> gracze) {
        int suma = 0;
        for (int i = 0; i < liczbaGraczy; i++) {
            if (gracze.get(i).getReka().size() == 0) suma++;
        }
        liczbaPrzegranych = suma;
    }
}