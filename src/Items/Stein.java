package Items;

public class Stein extends Artikel{
    private String Art;
    private String Gewicht;

    public Stein(String art, String gewicht){
        this.Art = art;
        this.Gewicht = gewicht;
        this.Artikeltyp = "Stein";
        this.img = this.Art + this.Gewicht + this.Artikeltyp;
    }



    public String getGewicht() {
        return Gewicht;
    }



    @Override
    public boolean equals(Object o){
        if(o == this){
            return true;
        }
        if (o == null || getClass() != o.getClass()) return false;
        Stein that = (Stein) o;
        return Art.equals(that.Art) && Gewicht.equals(that.Gewicht);
    }
}
