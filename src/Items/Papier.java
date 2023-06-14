package Items;

public class Papier extends Artikel {
    private String Farbe;
    private String Groesse;

    public Papier(String farbe, String groesse) {
        this.Farbe = farbe;
        this.Groesse = groesse;
        this.Artikeltyp = "Papier";
        this.img = this.Farbe + this.Groesse + this.Artikeltyp;
    }

    @Override
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        if (o == null || getClass() != o.getClass()) return false;
        Papier that = (Papier) o;
        return Farbe.equals(that.Farbe) && Groesse.equals(that.Groesse);
    }



}
