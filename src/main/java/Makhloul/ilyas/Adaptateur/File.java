package Makhloul.ilyas.Adaptateur;

import Makhloul.ilyas.Liste;

import java.util.List;

public class File extends MaListe {


    public File(Liste liste) {
        super(liste);
    }

    @Override
    public void push(int val) {
        super.push(val);

    }

    @Override
    public int pop() {
        if (!this.estVide()) {
            int v=  liste.getPremier().getValeur();
            liste.setPremier(liste.getPremier().getSuivant());

            this.notifyAllObs();
            return v ;

        } else {
            throw new IllegalStateException("La file est vide !"); // Lève une exception si la file est vide
        }

    }
}
