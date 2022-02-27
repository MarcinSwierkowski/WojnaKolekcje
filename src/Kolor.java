public enum Kolor {

    TREFL(1,"♣"),
    PIK(2,"♠"),
    KARO(3,"♦"),
    KIER(4,"♥");

    private int mocKoloru;
    private String symbol;

    Kolor(int mocKoloru, String symbol) {
        this.mocKoloru = mocKoloru;
        this.symbol = symbol;
    }

    public int getMocKoloru() {
        return mocKoloru;
    }

    public String getSymbol() {
        return symbol;
    }
}