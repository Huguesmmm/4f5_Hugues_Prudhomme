package echecs.commandes.peut_jouer;

import echecs.pages.partie.modeles.Position;
import ntro.commandes.CommandePourEnvoi;

public interface PeutJouerPourEnvoie extends CommandePourEnvoi {
    void setPosition(Position position);
}
