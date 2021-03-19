package echecs.commandes.peut_jouer;

import echecs.pages.partie.modeles.Position;
import ntro.commandes.CommandeRecue;

public interface PeutJouerRecue extends CommandeRecue {
    Position getPosition();
}
