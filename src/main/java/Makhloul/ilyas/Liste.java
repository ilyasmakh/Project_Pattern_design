package Makhloul.ilyas;

import java.util.concurrent.atomic.AtomicReference;

public class Liste {
    ElementListe premier ;

    public Liste(){}
   public Liste(ElementListe p){
       premier=p;
   }

    public ElementListe getPremier() {
        return premier;
    }

    public void setPremier(ElementListe premier) {
        this.premier = premier;
    }

    public int getMin(){
        ElementListe p = this.getPremier();
        int min = p.getValeur();
        while(p!=null){
            if(p.getValeur()<min){
                min = p.getValeur();
            }
            p = p.getSuivant();
        }
        return min ;
    }

    public void supprimerElement(int v){
        ElementListe p = this.getPremier();
        if(p.getValeur()==v){ this.setPremier(p.getSuivant()); return ;}
        else if(p.getValeur()==v && p.getSuivant()==null){ this.setPremier(null); return ;}

        ElementListe tmp = this.getPremier();
        p = p.getSuivant();
        while(p!=null){
            if(p.getValeur()==v && p.getSuivant()!=null){
                tmp.setSuivant(p.getSuivant()); return ;
            }
            else if(p.getValeur()==v && p.getSuivant()==null){
                tmp.setSuivant(null); ; return ;
            }
            tmp = tmp.getSuivant();
            p=p.getSuivant();
        }
    }

    public Liste copieListe(){
        ElementListe current = this.getPremier();
        Liste newListe = new Liste(new ElementListe(this.getPremier().getValeur()));
        ElementListe p = newListe.getPremier();
        while( current.getSuivant() != null ) {
            current =  current.getSuivant() ;
            p.setSuivant(new ElementListe(current.getValeur()));
            p = p.getSuivant() ;
        }
        return newListe ;
    }

}
