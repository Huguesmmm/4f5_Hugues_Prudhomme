package echecs.pages.partie.controleurs;

import echecs.pages.partie.afficheurs.AfficheurPartie;
import echecs.pages.partie.modeles.Partie;
import echecs.pages.partie.modeles.PartieLectureSeule;
import echecs.pages.partie.vues.VuePartie;
import ntro.debogage.J;
import ntro.mvc.controleurs.ControleurModeleVue;

public abstract class  ControleurPartie<PLS extends PartieLectureSeule,
        P extends Partie<PLS>,
        V extends VuePartie,
        A extends AfficheurPartie<PLS, V>>

        extends ControleurModeleVue<PLS, P, V, A> {


    @Override
    protected void obtenirMessagesPourEnvoi() {
        J.appel(this);


    }

    @Override
    protected void installerReceptionCommandes() {
        J.appel(this);

        installerReceptionCommandes();
    }

    @Override
    protected void installerReceptionMessages() {
        J.appel(this);
    }

    @Override
    protected void demarrer() {
        J.appel(this);
    }
}
