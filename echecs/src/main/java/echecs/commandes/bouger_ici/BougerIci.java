package echecs.commandes.bouger_ici;

import echecs.pages.partie.modeles.Position;
import ntro.commandes.Commande;

public class BougerIci extends Commande<BougerIciPourEnvoi, BougerIciRecue>
                        implements BougerIciPourEnvoi, BougerIciRecue{
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
