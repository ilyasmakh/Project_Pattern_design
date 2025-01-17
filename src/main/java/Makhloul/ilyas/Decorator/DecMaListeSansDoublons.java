package Makhloul.ilyas.Decorator;

import Makhloul.ilyas.Adaptateur.MaListe;
import Makhloul.ilyas.ElementListe;
import Makhloul.ilyas.Liste;

import java.util.ArrayList;
import java.util.List;

public class DecMaListeSansDoublons extends DecoratorMaListe {

    public DecMaListeSansDoublons(MaListe liste) {
        super(liste);  // Passer la liste au constructeur de la classe parente (DecoratorMaListe)
       MaListe l = MaListeSansDoublons(liste);  // Appliquer la logique de suppression des doublons
        this.setMaListe(l);  // Mettre à jour la liste avec la version sans doublons
        this.setListe(l.getListe());
    }

    public MaListe MaListeSansDoublons(MaListe liste) {
        ElementListe current = liste.getListe().getPremier();

        // Nouvelle liste totalement indépendante
        Liste newListe = new Liste();
        ElementListe dernierAjoute = null;

        while (current != null) {
            // Vérifier si la valeur existe déjà dans la newListe
            boolean existeDeja = false;
            ElementListe temp = newListe.getPremier();

            while (temp != null) {
                if (temp.getValeur() == current.getValeur()) {
                    existeDeja = true;
                    break;
                }
                temp = temp.getSuivant();
            }

            // Ajouter la valeur si elle n'existe pas dans newListe
            if (!existeDeja) {
                ElementListe nouvelElement = new ElementListe(current.getValeur());
                if (dernierAjoute == null) {
                    // Premier élément ajouté
                    newListe.setPremier(nouvelElement);
                } else {
                    // Lier le nouvel élément à la liste
                    dernierAjoute.setSuivant(nouvelElement);
                }
                dernierAjoute = nouvelElement;
            }

            current = current.getSuivant();
        }

        // Retourner une nouvelle instance totalement indépendante de liste
        return new MaListe(newListe);
    }

    @Override
    public void afficher() {
        maListe.afficher();
    }
}
