package main;

import Items.Artikel;
import Items.Holz;
import Items.Papier;
import Items.Stein;

public class Auftrag {
    private Artikel item;
    private int Wert;
    private String typ; //Einlagerung oder Auslagerung

    public Auftrag(String[] auftrag){
        this.typ = auftrag[1];
        switch (auftrag[2]) {
            case "Papier" -> this.item = new Papier(auftrag[3], auftrag[4]);
            case "Holz" -> this.item = new Holz(auftrag[3], auftrag[4]);
            case "Stein" -> this.item = new Stein(auftrag[3], auftrag[4]);
        }
        this.Wert = Integer.parseInt(auftrag[5]);

    }

    public int getWert() {
        return Wert;
    }

    public Artikel getItem() {
        return item;
    }



    public String getTyp() {
        return typ;
    }
}
