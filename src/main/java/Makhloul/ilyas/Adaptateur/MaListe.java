package Makhloul.ilyas.Adaptateur;

import Makhloul.ilyas.ElementListe;
import Makhloul.ilyas.Liste;
import Makhloul.ilyas.Observer.Observe;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;

public class MaListe extends Observe {

    Liste liste ;

   public MaListe(){

   }
    public MaListe(Liste liste){
        this.liste = liste;
        this.notifyAllObs();
    }
     public void push(int val){
         ElementListe current = liste.getPremier();
         while (current != null) {

             if(current.getSuivant()==null)   {current.setSuivant(new ElementListe(val)); break ; }
             current = current.getSuivant();
         }
         this.notifyAllObs();

     }

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

    public boolean estVide(){
        return liste == null || liste.getPremier()== null ;
    }

    public void afficher(){
         if(estVide()) System.out.println("Liste vide") ;
         else{

             ElementListe current = liste.getPremier();
             while (current != null) {

                 System.out.print(current.getValeur() + " -> ");
                 current = current.getSuivant();
             }

         }
    }
    public String toString(){
       String s = "";
        if(estVide()) s = "Liste vide" ;
        else{

            ElementListe current = liste.getPremier();
            while (current != null) {
                 s += current.getValeur() + " -> ";

                current = current.getSuivant();
            }

        }
        return s ;
    }
    public int getLongeur(){
       int s=0 ;
       if (estVide()) return 0 ;
       else {
           ElementListe current = liste.getPremier();
           while (current != null) {
               s++ ;

               current = current.getSuivant();
           }


       }
       return s ;
    }
    public Integer getDernier(){

        if (estVide()) return null ;
        ElementListe current = liste.getPremier();

     int v =  current.getValeur();
            while (current != null) {

                v = current.getValeur();
                current = current.getSuivant();
            }



       return v;
    }

    public Liste getListe() {
        return liste;
    }

    public void setListe(Liste liste) {
        this.liste = liste;
    }

    public int getSomme(){
        if (estVide()) return 0 ;
        ElementListe current = liste.getPremier();

        int s = 0 ;
        while (current != null) {
            s += current.getValeur() ;

            current = current.getSuivant();
        }
        return s ;
    }

    public int getProduit(){
        if (estVide()) return 0 ;
        ElementListe current = liste.getPremier();

        int p = 1 ;
        while (current != null) {
            p *= current.getValeur() ;

            current = current.getSuivant();
        }
        return p ;
    }

    public boolean contient(int el){

        if (estVide()) return false  ;
        ElementListe current = liste.getPremier();


        while (current != null) {
          if(current.getValeur()==el) return true ;

            current = current.getSuivant();
        }
       return false ;
    }
}
