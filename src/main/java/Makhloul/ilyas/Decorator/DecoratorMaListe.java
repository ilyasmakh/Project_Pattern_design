package Makhloul.ilyas.Decorator;

import Makhloul.ilyas.Adaptateur.MaListe;

public class DecoratorMaListe extends MaListe {
    MaListe maListe;
    public DecoratorMaListe(MaListe liste) {
        super(liste.getListe());
        this.maListe = liste  ;
    }

    public void setMaListe(MaListe liste) {
        this.maListe = liste;
    }

    @Override
    public void afficher() {
        maListe.afficher();
    }
}
