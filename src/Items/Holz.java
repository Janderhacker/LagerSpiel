package Items;

public class Holz extends Artikel {
    private final String Art;
    private final String Form;

    public Holz(String art, String form) {
        this.Art = art;
        this.Form = form;
        this.Artikeltyp = "Holz";
        this.img = this.Art + this.Form + this.Artikeltyp;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) return false;
        Holz that = (Holz) o;
        return Art.equals(that.Art) && Form.equals(that.Form);
    }


}
