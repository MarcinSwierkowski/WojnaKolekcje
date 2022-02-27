import java.util.Arrays;
import java.util.List;

public class SingletonConfig {

    private static final SingletonConfig instance = new SingletonConfig();

    public SingletonConfig() {
    }

    public static SingletonConfig getInstance() {
        return instance;
    }


    private final int liczbaGraczy = 4;

    private final List<KartaDoGry> talia = Arrays.asList(

            new KartaDoGry(Figura.DWOJKA, Kolor.KIER),
            new KartaDoGry(Figura.TROJKA, Kolor.KIER),
            new KartaDoGry(Figura.CZWORKA, Kolor.KIER),
            new KartaDoGry(Figura.PIATKA, Kolor.KIER),
            new KartaDoGry(Figura.SZOSTKA, Kolor.KIER),
            new KartaDoGry(Figura.SIODEMKA, Kolor.KIER),
            new KartaDoGry(Figura.OSEMKA, Kolor.KIER),
            new KartaDoGry(Figura.DZIEWIATKA, Kolor.KIER),
            new KartaDoGry(Figura.DZIESIATKA, Kolor.KIER),
            new KartaDoGry(Figura.WALET, Kolor.KIER),
            new KartaDoGry(Figura.DAMA, Kolor.KIER),
            new KartaDoGry(Figura.KROL, Kolor.KIER),
            new KartaDoGry(Figura.AS, Kolor.KIER),

            new KartaDoGry(Figura.DWOJKA, Kolor.KARO),
            new KartaDoGry(Figura.TROJKA, Kolor.KARO),
            new KartaDoGry(Figura.CZWORKA, Kolor.KARO),
            new KartaDoGry(Figura.PIATKA, Kolor.KARO),
            new KartaDoGry(Figura.SZOSTKA, Kolor.KARO),
            new KartaDoGry(Figura.SIODEMKA, Kolor.KARO),
            new KartaDoGry(Figura.OSEMKA, Kolor.KARO),
            new KartaDoGry(Figura.DZIEWIATKA, Kolor.KARO),
            new KartaDoGry(Figura.DZIESIATKA, Kolor.KARO),
            new KartaDoGry(Figura.WALET, Kolor.KARO),
            new KartaDoGry(Figura.DAMA, Kolor.KARO),
            new KartaDoGry(Figura.KROL, Kolor.KARO),
            new KartaDoGry(Figura.AS, Kolor.KARO),

            new KartaDoGry(Figura.DWOJKA, Kolor.PIK),
            new KartaDoGry(Figura.TROJKA, Kolor.PIK),
            new KartaDoGry(Figura.CZWORKA, Kolor.PIK),
            new KartaDoGry(Figura.PIATKA, Kolor.PIK),
            new KartaDoGry(Figura.SZOSTKA, Kolor.PIK),
            new KartaDoGry(Figura.SIODEMKA, Kolor.PIK),
            new KartaDoGry(Figura.OSEMKA, Kolor.PIK),
            new KartaDoGry(Figura.DZIEWIATKA, Kolor.PIK),
            new KartaDoGry(Figura.DZIESIATKA, Kolor.PIK),
            new KartaDoGry(Figura.WALET, Kolor.PIK),
            new KartaDoGry(Figura.DAMA, Kolor.PIK),
            new KartaDoGry(Figura.KROL, Kolor.PIK),
            new KartaDoGry(Figura.AS, Kolor.PIK),

            new KartaDoGry(Figura.DWOJKA, Kolor.TREFL),
            new KartaDoGry(Figura.TROJKA, Kolor.TREFL),
            new KartaDoGry(Figura.CZWORKA, Kolor.TREFL),
            new KartaDoGry(Figura.PIATKA, Kolor.TREFL),
            new KartaDoGry(Figura.SZOSTKA, Kolor.TREFL),
            new KartaDoGry(Figura.SIODEMKA, Kolor.TREFL),
            new KartaDoGry(Figura.OSEMKA, Kolor.TREFL),
            new KartaDoGry(Figura.DZIEWIATKA, Kolor.TREFL),
            new KartaDoGry(Figura.DZIESIATKA, Kolor.TREFL),
            new KartaDoGry(Figura.WALET, Kolor.TREFL),
            new KartaDoGry(Figura.DAMA, Kolor.TREFL),
            new KartaDoGry(Figura.KROL, Kolor.TREFL),
            new KartaDoGry(Figura.AS, Kolor.TREFL)
    );

    public int getLiczbaGraczy() {
        return liczbaGraczy;
    }

    public List<KartaDoGry> getTalia() {
        return talia;
    }
}