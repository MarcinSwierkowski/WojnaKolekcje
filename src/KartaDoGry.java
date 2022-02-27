import java.util.Objects;

public class KartaDoGry implements Comparable<KartaDoGry> {

    private Figura figura;
    private Kolor kolor;

    public KartaDoGry(Figura figura, Kolor kolor) {
        this.figura = figura;
        this.kolor = kolor;
    }

    public Figura getFigura() {
        return figura;
    }


    @Override
    public String toString() {
        return figura.getSymbol() + kolor.getSymbol();

    }


    @Override
    public int compareTo(KartaDoGry o) {
        if (this.figura.getMocFigury() > o.figura.getMocFigury()) return 1;
        else if (this.figura.getMocFigury() < o.figura.getMocFigury()) return -1;

        else {
            if (this.kolor.getMocKoloru() > o.kolor.getMocKoloru()) return 1;
            else if (this.kolor.getMocKoloru() < o.kolor.getMocKoloru()) return -1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KartaDoGry that = (KartaDoGry) o;
        return figura == that.figura && kolor == that.kolor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(figura, kolor);
    }
}
