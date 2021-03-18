package echecs.commandes.choisir_qui_commence;

import echecs.enumerations.Couleur;
import ntro.commandes.Commande;
import ntro.debogage.J;

public class ChoisirQuiCommence extends Commande<ChoisirQuiCommencePourEnvoi, ChoisirQuiCommenceRecue>
        implements ChoisirQuiCommencePourEnvoi, ChoisirQuiCommenceRecue {
    private Couleur couleur;

    @Override
    public void setCouleur(Couleur couleur) {
        J.appel(this);
        this.couleur = couleur;
    }
    @Override
    public Couleur getCouleur() {
        J.appel(this);

        return couleur;
    }
}
