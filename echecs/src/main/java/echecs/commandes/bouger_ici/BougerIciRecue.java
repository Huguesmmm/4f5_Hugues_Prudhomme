package echecs.commandes.bouger_ici;

import echecs.pages.partie.modeles.Position;
import ntro.commandes.CommandeRecue;

public interface BougerIciRecue extends CommandeRecue {
    Position getPosition();
}
