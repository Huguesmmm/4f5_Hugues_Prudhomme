package echecs.commandes.choisir_qui_commence;

import echecs.enumerations.Couleur;
import ntro.commandes.CommandeRecue;

public interface ChoisirQuiCommenceRecue extends CommandeRecue {
    Couleur getCouleur();
}
