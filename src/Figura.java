public enum Figura {

    DWOJKA(2,"2"),
    TROJKA(3,"3"),
    CZWORKA(4,"4"),
    PIATKA(5,"5"),
    SZOSTKA(6,"6"),
    SIODEMKA(7,"7"),
    OSEMKA(8,"8"),
    DZIEWIATKA(9,"9"),
    DZIESIATKA(10,"10"),
    WALET(11,"J"),
    DAMA(12,"D"),
    KROL(13,"K"),
    AS(14,"A");

    private int mocFigury;
    private String symbol;

    Figura(int mocFigury, String symbol) {
        this.mocFigury = mocFigury;
        this.symbol = symbol;
    }

    public int getMocFigury() {
        return mocFigury;
    }

    public String getSymbol() {
        return symbol;
    }
}