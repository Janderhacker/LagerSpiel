package main;

import java.util.ArrayList;
import java.util.List;

public class Game {

    List<String> transactions = new ArrayList<>();
    private int money = 0;

    private int umsatz = 0;
    private int kosten = 0;
    private final Auftrag[] auftragsEingang = new Auftrag[3];
    private final Lager lager = new Lager();

    private final Orders order = new Orders();

    public int getMoney() {
        return money;
    }


    //Gibt den Aufgaben typ zurück
    public String atyp(int aNr) {
        try {
            return auftragsEingang[aNr].getTyp();
        } catch (NullPointerException e) {
            return "Null";
        }

    }

    //Gibt den nächsten Auftrag zurück
    public String getAuftrag() {
        String[] stringArray;
        try {
            stringArray = order.getNextOrder();
        } catch (ArrayIndexOutOfBoundsException e) {
            return "End";
        }

        StringBuilder sb = new StringBuilder();
        if (auftragsEingang[0] == null) {
            auftragsEingang[0] = new Auftrag(stringArray);
        } else if (auftragsEingang[1] == null) {
            auftragsEingang[1] = new Auftrag(stringArray);
        } else if (auftragsEingang[2] == null) {
            auftragsEingang[2] = new Auftrag(stringArray);
        }
        for (int i = 1; i < stringArray.length; i++) {
            sb.append(stringArray[i]).append("\r\n");
        }
        return sb.toString();
    }

    //Lehnt einen Auftrag ab
    public void AuftragAblehnen(int aNr) {
        money -= auftragsEingang[aNr].getWert();
        kosten += auftragsEingang[aNr].getWert();
        transactions.add("Auftrag abgelehnt -" + auftragsEingang[aNr].getWert());
        auftragsEingang[aNr] = null;
    }

    //Entscheidet ob es sich um einen Auslagerungs oder Einlagerungs auftrag handelt
    public boolean ausfuehren(int aNr, int row, int col) {
        if (auftragsEingang[aNr].getTyp().equals("Einlagerung")) {
            return einlagern(aNr, row, col);
        } else return auslagern(aNr, row, col);
    }

    //Lagert ein Item aus dem Lager aus
    private boolean auslagern(int aNr, int row, int col) {
        if (auftragsEingang[aNr].getItem().equals(lager.getItem(row, col))) {
            if (lager.remove(row, col)) {
                transactions.add("Auslagerung +" + auftragsEingang[aNr].getWert());
                money += auftragsEingang[aNr].getWert();
                umsatz += auftragsEingang[aNr].getWert();
                auftragsEingang[aNr] = null;
                return true;
            } else return false;
        } else return false;
    }

    //Zerstört ein Item aus dem Lager
    public boolean destroy(int row, int col) {

        if (lager.remove(row, col)) {
            money -= 300;
            kosten += 300;
            transactions.add("Verschrottung -300");
            return true;
        } else return false;
    }

    //Lagert ein Item in das Lager ein
    private boolean einlagern(int aNr, int row, int col) {
        if (lager.add(row, col, auftragsEingang[aNr].getItem())) {
            money += auftragsEingang[aNr].getWert();
            transactions.add("Einlagerung +" + auftragsEingang[aNr].getWert());
            umsatz += auftragsEingang[aNr].getWert();
            auftragsEingang[aNr] = null;
            return true;
        } else return false;
    }

    //Gibt den Pfad zum Bild des Produktes welches im Lager an stelle row,col ist zurück
    public String img(int row, int col) {
        return lager.getItem(row, col).getImg();
    }

    //Gibt den Pfad vom Bild des Items im auftragsEingang[aNr] zurück
    public String img(int aNr) {
        return auftragsEingang[aNr].getItem().getImg();
    }

    //Gibt alle getätigten Transaktionen zurück
    public List<String> getTransactions() {
        return transactions;
    }

    //Gibt die Kosten zurück
    public int getKosten() {
        return kosten;
    }

    //Gibt den Umsatz zurück
    public int getUmsatz() {
        return umsatz;
    }
}
