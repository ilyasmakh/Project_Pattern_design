package Makhloul.ilyas.Observer;

import Makhloul.ilyas.Adaptateur.MaListe;

public abstract class Observateur {

    public abstract void update(Observe o );

   public abstract int getEtat();
    public abstract void setEtat(int v);

}
