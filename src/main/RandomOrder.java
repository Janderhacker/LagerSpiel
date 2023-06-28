package main;

import java.util.concurrent.ThreadLocalRandom;

public class RandomOrder {

    //Class to generate random Orders after finishing Oders.java
    String[] typ = {"Auslagerung","Einlagerung"};
    String[] Item = {"Papier", "Holz", "Stein"};
    String[] Farbe = {"Weiss", "Gruen", "Blau"};
    String[] Groese = {"A3", "A4", "A5"};

    String[] hArt = {"Buche", "Kiefer", "Eiche"};
    String[] Form = {"Bretter", "Scheit", "Balken"};

    String[] sArt = {"Granit", "Marmor", "Sandstein"};
    String[] Gewicht= {"Leicht", "Mittel", "Schwer"};


    public String[] getNextOrder() {
        String[] order = new String[6];
        order[0]="0";
        int randt = ThreadLocalRandom.current().nextInt(0,2);
        order[1] = typ[randt];
        int rand1 = ThreadLocalRandom.current().nextInt(0,3);
        int rand2 = ThreadLocalRandom.current().nextInt(0,3);
        int rand3 = ThreadLocalRandom.current().nextInt(0,3);
        int worth = ThreadLocalRandom.current().nextInt(2,21);
        switch (Item[rand1]) {
            case "Papier" -> {
                order[2] = "Papier";
                order[3] = Farbe[rand2];
                order[4] = Groese[rand3];
            }
            case "Holz" -> {
                order[2] = "Holz";
                order[3] = hArt[rand2];
                order[4] = Form[rand3];
            }
            case "Stein" -> {
                order[2] = "Stein";
                order[3] = sArt[rand2];
                order[4] = Gewicht[rand3];
            }
        }
        order[5] = Integer.toString(worth*100);
        return order;
    }
}
