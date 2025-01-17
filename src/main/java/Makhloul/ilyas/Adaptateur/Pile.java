package Makhloul.ilyas.Adaptateur;

import Makhloul.ilyas.ElementListe;
import Makhloul.ilyas.Liste;

import java.util.List;

public class Pile extends MaListe {

    public Pile(Liste liste) {
        super(liste);
    }

    @Override
    public void push(int val) {
        ElementListe premier = liste.getPremier();
        ElementListe newPremier= new ElementListe(val);
        newPremier.setSuivant(premier);
        liste.setPremier(newPremier);
        this.notifyAllObs();
    }

    @Override
    public int pop() {
        if (!this.estVide()) {
            int v=  liste.getPremier().getValeur();
            liste.setPremier(liste.getPremier().getSuivant());
            this.notifyAllObs();
            return v ;

        } else {
            throw new IllegalStateException("La pile est vide !"); // Lève une exception si la file est vide
        }

    }

}
