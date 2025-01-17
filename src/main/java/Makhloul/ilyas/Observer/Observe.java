package Makhloul.ilyas.Observer;

import java.util.ArrayList;
import java.util.List;

public class Observe {

    List<Observateur> Observateurs  = new ArrayList<>();

    public void ajouterObs(Observateur obs) {
        Observateurs.add(obs);
    }
    public void supprimerObs(Observateur obs) {
        Observateurs.remove(obs);
    }
    public void notifyAllObs(){
       if(Observateurs !=null) {if(Observateurs.size()>0){
         for (Observateur obs : Observateurs) {
                obs.update(this);
        }
    }}}

    public List<Observateur> getObservateurs() {
        return Observateurs;
    }
}
