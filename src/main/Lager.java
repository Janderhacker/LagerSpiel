package main;

import Items.Artikel;
import Items.Stein;

import java.util.Objects;

public class Lager {
    /*
    Lager layout
    [row][col]
    30 31 32 33
    20 21 22 23
    10 11 12 13
    00 01 02 03
     */
    private final Artikel[][] items = new Artikel[4][4];

    // Fügt dem Lager ein Item an der Stelle  row, column hinzu
    public boolean add(int row, int column, Artikel item) {
        if (this.items[row][column] != null) {
            return false;
        } else {
            if (item.getArtikeltyp().equals("Stein")) {
                if (!((Stein) item).getGewicht().equals("Schwer")) {
                    if (!Objects.equals(((Stein) item).getGewicht(), "Mittel")) {
                        this.items[row][column] = item;
                        return true;
                    } else if (row == 3) {
                        return false;
                    } else {
                        this.items[row][column] = item;
                        return true;
                    }

                } else if (row == 0) {
                    this.items[row][column] = item;
                    return true;
                } else return false;
            } else {
                this.items[row][column] = item;
                return true;
            }
        }
    }

    // Entfernt das Item an der Stelle row, col
    public boolean remove(int row, int column) {
        if (items[row][column] == null) {
            return false;
        } else {
            items[row][column] = null;
            return true;
        }
    }

    //Gibt das Item an der Stelle
    public Artikel getItem(int row, int col) {
        return this.items[row][col];
    }
}