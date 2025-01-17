package Makhloul.ilyas.Observer;

import Makhloul.ilyas.Adaptateur.MaListe;

public class  ProduitListeObs extends Observateur{

    int produit = 0 ;

    public ProduitListeObs (int v ){
        this.produit = v;
    }
    @Override
    public void update(Observe o ) {
      MaListe l = (MaListe)o;
      produit = l.getProduit() ;
      System.out.println("produit : " + l.getProduit());
    }
    @Override
    public int getEtat(){
        return produit;
    }

    @Override
    public void setEtat(int v) {
        this.produit = v ;
    }

}
