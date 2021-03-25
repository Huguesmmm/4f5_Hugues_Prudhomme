package echecs.pages.partie.controleurs;

import echecs.commandes.bouger_ici.BougerIciRecue;
import echecs.commandes.peut_jouer.PeutJouer;
import echecs.commandes.peut_jouer.PeutJouerRecue;
import echecs.pages.partie.afficheurs.AfficheurPartie;
import echecs.pages.partie.modeles.*;
import echecs.pages.partie.vues.VuePartie;
import ntro.debogage.J;
import ntro.mvc.controleurs.ControleurModeleVue;
import ntro.mvc.controleurs.RecepteurCommandeMVC;

import java.util.Collections;
import java.util.List;

import static echecs.Constantes.DIMENSION_PLATEAU;

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

        installerRecepteurCommande(PeutJouer.class, new RecepteurCommandeMVC<PeutJouerRecue>(){
            @Override
            public void executerCommandeMVC(PeutJouerRecue peutJouerRecue) {
                J.appel(this);
                reagirCommandePeutJouer(peutJouerRecue);
            }
        });
    }

    protected void reagirCommandeBougerIci(BougerIciRecue bougerIciRecue){
        J.appel(this);

        // Aller chercher le modele

    }

    protected void reagirCommandePeutJouer(PeutJouerRecue peutJouerRecue){
        J.appel(this);

    }

    protected List<CaseLectureSeule> getCasesActives(Position position){
        PlateauLectureSeule plateau = getModele().getPlateau();
        CaseLectureSeule[][] cases = getModele().getPlateau().getPlateauCases();
        List<CaseLectureSeule> casesActives = Collections.emptyList();

        CaseLectureSeule aCase = cases[position.getColonne().ordinal()][DIMENSION_PLATEAU - position.getRang()];


        if(aCase.isOccupied() && aCase.getPiece().getCouleur() == plateau.getCouleurCourante()){

        }
        return casesActives;
    }

    protected List<CaseLectureSeule> mouvementsPossibles(Case aCase){
        List<CaseLectureSeule> mouvementsPossibles = Collections.emptyList();

        if(aCase.isOccupied()){
            switch (aCase.getPiece().getTypePiece()){
                case PION:
                    break;
                case TOUR:
                    break;
                case FOU:
                    break;
                case CAVALIER:
                    break;
                case REINE:
                    break;
                case ROI:
                    break;
            }
        }
        return mouvementsPossibles;
    }

    private List<CaseLectureSeule> getMouvementsPion(Position position, Plateau plateau){
        List<CaseLectureSeule> mouvementsPion = Collections.emptyList();
        return mouvementsPion;
    }

    private List<CaseLectureSeule> getMouvementsFou(Position position, Plateau plateau){
        List<CaseLectureSeule> mouvementsFou = Collections.emptyList();
        return mouvementsFou;
    }

    private List<CaseLectureSeule> getMouvementsTour(Position position, Plateau plateau){
        List<CaseLectureSeule> mouvementsTour = Collections.emptyList();
        return mouvementsTour;
    }

    private List<CaseLectureSeule> getMouvementsReine(Position position, Plateau plateau){
        List<CaseLectureSeule> mouvementsReine = Collections.emptyList();
        return mouvementsReine;
    }

    private List<CaseLectureSeule> getMouvementsCavalier(Position position, Plateau Plateau){
        List<CaseLectureSeule> mouvementsCavalier = Collections.emptyList();
        return mouvementsCavalier;
    }

    private List<CaseLectureSeule> getMouvementsRoi(Position position, Plateau plateau){
        List<CaseLectureSeule> mouvementsRoi = Collections.emptyList();
        return mouvementsRoi;
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
