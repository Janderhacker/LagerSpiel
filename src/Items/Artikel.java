package Items;

public class Artikel {
    protected String Artikeltyp;
    protected String img;


    public String getArtikeltyp() {
        return Artikeltyp;
    }


    @Override
    public boolean equals(Object o){
        return o == this;
    }
    
    public String getImg() {
        return img;
    }

}
