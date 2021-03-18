package echecs.commandes.bouger_ici;

import echecs.pages.partie.modeles.Position;
import ntro.commandes.CommandePourEnvoi;

public interface BougerIciRecue extends CommandePourEnvoi {
    void setPosition(Position position);
}
