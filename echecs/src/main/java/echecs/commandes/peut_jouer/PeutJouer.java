package echecs.commandes.peut_jouer;

import echecs.pages.partie.modeles.Position;
import ntro.commandes.Commande;

public class PeutJouer extends Commande<PeutJouerPourEnvoie, PeutJouerRecue>
                            implements PeutJouerPourEnvoie, PeutJouerRecue {
    private Position position;

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return position;
    }
}
