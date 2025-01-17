package Makhloul.ilyas;

public class ElementListe {


    int valeur ;
    ElementListe suivant ;



    public ElementListe(int v) {
        this.valeur = v ;
    }

    public int getValeur() {
        return valeur;
    }

    public ElementListe getSuivant() {
        return suivant;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public ElementListe setSuivant(ElementListe suivant) {
        this.suivant = suivant;

        return suivant;
    }
}
