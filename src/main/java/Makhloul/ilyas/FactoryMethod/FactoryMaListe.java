package Makhloul.ilyas.FactoryMethod;

import Makhloul.ilyas.Adaptateur.MaListe;
import Makhloul.ilyas.Liste;

import java.util.List;

public   class FactoryMaListe {

    public  MaListe getMaListe( Liste liste ){
        return new MaListe(liste);
    }
}
