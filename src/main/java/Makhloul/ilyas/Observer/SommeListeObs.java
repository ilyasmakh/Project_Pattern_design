package Makhloul.ilyas.Observer;

import Makhloul.ilyas.Adaptateur.MaListe;

import java.util.Observable;

public class SommeListeObs extends Observateur {

    int somme = 0 ;

    public SommeListeObs (int v ){
        this.somme = v;
    }
    @Override
    public void update(Observe o  ) {
        MaListe l = (MaListe)o;
        somme = l.getSomme() ;
        System.out.println("Somme : "  + l.getSomme());

    }
    @Override
    public int getEtat(){
        return somme  ;
    }

    @Override
    public void setEtat(int v) {
        this.somme = v ;
    }
}
