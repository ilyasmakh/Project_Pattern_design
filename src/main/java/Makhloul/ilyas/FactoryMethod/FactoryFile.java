package Makhloul.ilyas.FactoryMethod;

import Makhloul.ilyas.Adaptateur.File;
import Makhloul.ilyas.Adaptateur.MaListe;
import Makhloul.ilyas.Liste;

import java.util.List;


public class FactoryFile extends FactoryMaListe{
    @Override
    public MaListe getMaListe( Liste liste) {
        return new File(liste);
    }
}
