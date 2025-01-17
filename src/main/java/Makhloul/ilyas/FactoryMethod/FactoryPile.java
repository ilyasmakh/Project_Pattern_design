package Makhloul.ilyas.FactoryMethod;

import Makhloul.ilyas.Adaptateur.MaListe;
import Makhloul.ilyas.Adaptateur.Pile;
import Makhloul.ilyas.Liste;

import java.util.List;

public class FactoryPile extends FactoryMaListe{
    @Override
    public MaListe getMaListe(Liste liste) {
        return new Pile(liste);
    }
}
