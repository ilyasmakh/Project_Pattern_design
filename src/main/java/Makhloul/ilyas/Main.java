package Makhloul.ilyas;

import Makhloul.ilyas.Adaptateur.File;
import Makhloul.ilyas.Adaptateur.MaListe;
import Makhloul.ilyas.Adaptateur.Pile;
import Makhloul.ilyas.Decorator.DecMaListeSansDoublons;
import Makhloul.ilyas.Decorator.DecMaListeTriee;
import Makhloul.ilyas.FactoryMethod.FactoryFile;
import Makhloul.ilyas.FactoryMethod.FactoryMaListe;
import Makhloul.ilyas.FactoryMethod.FactoryPile;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
  public static void fctsBase(){
      ElementListe e1 = new ElementListe(4);
      ElementListe e2 = new ElementListe(0);
      ElementListe e3 = new ElementListe(15);
      ElementListe e4 = new ElementListe(-2);
      ElementListe e5 = new ElementListe(0);
      e1.setSuivant(e2);
      e2.setSuivant(e3);
      e3.setSuivant(e4);
      e4.setSuivant(e5);
      Liste liste = new Liste(e1);
      new MaListe(liste).afficher(); System.out.println();
      liste.supprimerElement(0);
      new MaListe(liste).afficher(); System.out.println();
      liste.supprimerElement(0);
      new MaListe(liste).afficher();
  }
    public static void testDecorateur(){

        ElementListe e1 = new ElementListe(4);
        ElementListe e2 = new ElementListe(0);
        ElementListe e3 = new ElementListe(15);
        ElementListe e4 = new ElementListe(-2);
        ElementListe e5 = new ElementListe(0);
        e1.setSuivant(e2);
        e2.setSuivant(e3);
        e3.setSuivant(e4);
        e4.setSuivant(e5);
        Liste liste = new Liste(e1);

        MaListe maListe = new MaListe(liste);
       MaListe l2 = new DecMaListeTriee(maListe);

       MaListe l3 = new DecMaListeSansDoublons(maListe);



        MaListe l4 = new DecMaListeTriee( new DecMaListeSansDoublons(maListe));
        MaListe l5 = new DecMaListeSansDoublons(new DecMaListeTriee(maListe));

        System.out.print("Origine : "); maListe.afficher(); System.out.print("\n");
      System.out.print("Liste trié : "); l2.afficher();System.out.print("\n");
       System.out.print("Liste sans doublons : "); l3.afficher(); System.out.print("\n");
       System.out.print("Liste trié sans doublons : "); l4.afficher(); System.out.print("\n");
        System.out.print("Liste sans doublons trié  : "); l5.afficher(); System.out.print("\n");




    }
    /*
    public static void testFactoryMethod(){
        List<Integer> liste = new ArrayList<>(Arrays.asList(0, 15, 4, 15, 9));
        FactoryMaListe factoryMaListe= new FactoryMaListe();
        MaListe l1 = factoryMaListe.getMaListe(liste );
        System.out.print("Liste origine: "); l1.afficher(); System.out.print("\n");
        l1.push(17);
        System.out.print("Liste apres ajout : "); l1.afficher(); System.out.print("\n");
        l1.pop();
        System.out.print("Liste apres suppression : "); l1.afficher(); System.out.print("\n\n");
//------------------------------------
        FactoryPile factoryPile= new FactoryPile();
        MaListe pile = factoryPile.getMaListe(liste );
        System.out.print("Pile origine: "); pile.afficher(); System.out.print("\n");
        pile.push(17);
        System.out.print("Pile apres empilation : "); pile.afficher(); System.out.print("\n");
        pile.pop();
        System.out.print("Pile apres depiler: "); pile.afficher(); System.out.print("\n\n");
//--------------------------------
        FactoryFile factoryFile= new FactoryFile();
        MaListe file = factoryFile.getMaListe(liste );
        System.out.print("File origine: "); file.afficher(); System.out.print("\n");
        file.push(17);
        System.out.print("File apres empilation : "); file.afficher(); System.out.print("\n");
        file.pop();
        System.out.print("File apres depiler: "); file.afficher(); System.out.print("\n\n");


    }*/
    public static void testAdaptateur(){
        System.out.println("Ma Liste");
        ElementListe e1 = new ElementListe(4);
        ElementListe e2 = new ElementListe(0);
        ElementListe e3 = new ElementListe(15);
        ElementListe e4 = new ElementListe(-2);
        ElementListe e5 = new ElementListe(0);
        e1.setSuivant(e2);
        e2.setSuivant(e3);
        e3.setSuivant(e4);
        e4.setSuivant(e5);
        Liste liste = new Liste(e1);
        MaListe maListe = new MaListe(liste);
        maListe.afficher(); System.out.println();
        maListe.push(77);
        maListe.afficher();  System.out.println();
        maListe.pop();
        maListe.afficher();  System.out.println("\n");
        //------------------------
        System.out.println("File");
        File file = new File(liste);
        file.afficher(); System.out.println();
        file.push(100);
        file.afficher(); System.out.println();
        file.pop();
        file.afficher(); System.out.println();
        //------------------------
        System.out.println("Pile");
        Pile pile = new Pile(liste);
        pile.afficher(); System.out.println();
        pile.push(200);
        pile.afficher(); System.out.println();
        pile.pop();
        pile.afficher(); System.out.println();



    }
    public static void main(String[] args) {

      //  testDecorateur();
    //    testFactoryMethod();
            fctsBase();

    }
}