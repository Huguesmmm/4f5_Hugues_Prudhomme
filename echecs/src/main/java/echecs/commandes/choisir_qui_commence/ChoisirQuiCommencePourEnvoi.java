package echecs.commandes.choisir_qui_commence;

import echecs.enumerations.Couleur;
import ntro.commandes.CommandePourEnvoi;

public interface ChoisirQuiCommencePourEnvoi extends CommandePourEnvoi {
    void setCouleur(Couleur couleur);
}
