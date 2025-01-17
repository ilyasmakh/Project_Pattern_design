package Makhloul.ilyas.Decorator;

import Makhloul.ilyas.Adaptateur.MaListe;
import Makhloul.ilyas.ElementListe;
import Makhloul.ilyas.Liste;

import java.util.ArrayList;
import java.util.List;

public class DecMaListeTriee extends DecoratorMaListe {
    public DecMaListeTriee(MaListe liste) {
        super(liste);  // Passer la liste au constructeur de la classe parente (DecoratorMaListe)
        MaListe l = MaListeTriee(liste);  // Appliquer la logique de tri
        this.setMaListe(l);
        this.setListe(l.getListe());
    }

    public MaListe MaListeTriee(MaListe liste) {
        if( liste.estVide()) return null ;
        Liste l = liste.getListe() ;
        Liste newListe = l.copieListe();
        //--------------------------------
        int min = newListe.getMin();
        Liste newListe2 = new Liste(new ElementListe(min));
        MaListe maliste = new MaListe(newListe2);
        newListe.supprimerElement(min);
        while(newListe.getPremier()!=null){
            min = newListe.getMin();
           newListe.supprimerElement(min);
           maliste.push(min);
        }
   return maliste;
    }

    @Override
    public void afficher() {
        maListe.afficher();
    }
}
