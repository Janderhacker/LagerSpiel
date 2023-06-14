package main;

import Items.Artikel;
import Items.Stein;
import java.util.Objects;

public class Lager {
    private Artikel[][] items = new Artikel[4][4];

    public boolean add(int row, int column, Artikel item) {
        if (this.items[row][column] != null) {
            return false;
        } else {
            if (item.getArtikeltyp().equals("Stein")) {
                if (!((Stein) item).getGewicht().equals("Schwer")) {
                    if (!Objects.equals(((Stein) item).getGewicht(), "Mittel")) {
                        this.items[row][column] = item;
                        return true;
                    }
                    else if (row == 3){
                        return false;
                    }
                    else {
                        this.items[row][column] = item;
                        return true;
                    }

                } else if (row == 0) {
                    this.items[row][column] = item;
                    return true;
                } else return false;
            } else{
                this.items[row][column] = item;
                return true;
            }
        }
    }

    public boolean remove(int row, int column){
        if (items[row][column] == null) {
            return false;
        }
        else{
            items[row][column] = null;
            return true;
        }
    }

    public Artikel getItem(int row, int col){
        return this.items[row][col];
    }
}