package echecs.pages.partie.controleurs;

import echecs.commandes.bouger_ici.BougerIciRecue;
import echecs.commandes.peut_jouer.PeutJouer;
import echecs.commandes.peut_jouer.PeutJouerRecue;
import echecs.enumerations.Colonne;
import echecs.pages.partie.afficheurs.AfficheurPartie;
import echecs.pages.partie.modeles.*;
import echecs.pages.partie.vues.VuePartie;
import ntro.debogage.J;
import ntro.mvc.controleurs.ControleurModeleVue;
import ntro.mvc.controleurs.RecepteurCommandeMVC;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static echecs.Constantes.DIMENSION_PLATEAU;

public abstract class ControleurPartie<PLS extends PartieLectureSeule,
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

        installerRecepteurCommande(PeutJouer.class, new RecepteurCommandeMVC<PeutJouerRecue>() {
            @Override
            public void executerCommandeMVC(PeutJouerRecue peutJouerRecue) {
                J.appel(this);
                reagirCommandePeutJouer(peutJouerRecue);
            }
        });
    }

    protected void reagirCommandeBougerIci(BougerIciRecue bougerIciRecue) {
        J.appel(this);

        // Aller chercher le modele

    }

    protected void reagirCommandePeutJouer(PeutJouerRecue peutJouerRecue) {
        J.appel(this);

    }

    protected List<CaseLectureSeule> getCasesActives(Position position) {
        PlateauLectureSeule plateau = getModele().getPlateau();
        CaseLectureSeule[][] cases = getModele().getPlateau().getPlateauCases();
        List<CaseLectureSeule> casesActives = Collections.emptyList();

        CaseLectureSeule aCase = cases[position.getColonne().ordinal()][DIMENSION_PLATEAU - position.getRang()];


        if (aCase.isOccupied() && aCase.getPiece().getCouleur() == plateau.getCouleurCourante()) {

        }
        return casesActives;
    }

    protected List<Position> mouvementsPossibles(Case aCase, Plateau plateau) {
        List<Position> mouvementsPossibles = Collections.emptyList();

        if (aCase.isOccupied()) {
            switch (aCase.getPiece().getTypePiece()) {
                case PION:
                    mouvementsPossibles = getMouvementsPion(aCase, plateau);
                    break;
                case TOUR:
                    mouvementsPossibles = getMouvementsTour(aCase, plateau);
                    break;
                case FOU:
                    mouvementsPossibles = getMouvementsFou(aCase, plateau);
                    break;
                case CAVALIER:
                    mouvementsPossibles = getMouvementsCavalier(aCase, plateau);
                    break;
                case REINE:
                    mouvementsPossibles = getMouvementsReine(aCase, plateau);
                    break;
                case ROI:
                    mouvementsPossibles = getMouvementsRoi(aCase, plateau);
                    break;
            }
        }
        return mouvementsPossibles;
    }

    private List<Position> getMouvementsPion(Case aCase, Plateau plateau) {
        List<Position> mouvementsPossibles = Collections.emptyList();
        Position positionCourante = aCase.getPosition();
        mouvementsPossibles.add(construirePosition(positionCourante, 0, 1));
        if (aCase.getPiece().isPremierMouvement()) {
            mouvementsPossibles.add(construirePosition(positionCourante, 0, 2));
            return mouvementsPossibles;
        }

        mouvementsPossibles.add(construirePosition(positionCourante, 1, 1));
        mouvementsPossibles.add(construirePosition(positionCourante, -1, 1));
        Map<Position, Case> caseMap = plateau.getPositionCaseMap();
        List<Position> mouvementsValides = mouvementsPossibles.stream()
                .filter(caseMap::containsKey)
                .collect(Collectors.toList());

        return mouvementsValides.stream().filter((mouvement) -> {
            if (mouvement.getColonne().equals(aCase.getPosition().getColonne()) &&
                    caseMap.get(mouvement).isOccupied()) {
                return false;
            }

            return !caseMap.get(mouvement).getPiece().getCouleur().equals(aCase.getPiece().getCouleur());
        }).collect(Collectors.toList());
    }

    private List<Position> getMouvementsFou(Case aCase, Plateau plateau) {
        List<Position> mouvementsPossibles = Collections.emptyList();

        getMouvementsDiagonales(mouvementsPossibles,
                plateau.getPositionCaseMap(), aCase, -1, -1);
        getMouvementsDiagonales(mouvementsPossibles,
                plateau.getPositionCaseMap(), aCase, 1, 1);
        getMouvementsDiagonales(mouvementsPossibles,
                plateau.getPositionCaseMap(), aCase, -1, 1);
        getMouvementsDiagonales(mouvementsPossibles,
                plateau.getPositionCaseMap(), aCase, 1, -1);

        return mouvementsPossibles;
    }

    private void getMouvementsDiagonales(List<Position> mouvementsPossibles,
                                                   Map<Position, Case> caseMap,
                                                   Case aCase,
                                                   int decalageRangee,
                                                   int decalageColonne) {
        Position courante = aCase.getPosition();
        Position prochainePosition = construirePosition(courante, decalageColonne, decalageRangee);
        while(caseMap.containsKey(prochainePosition)){
            if(caseMap.get(prochainePosition).isOccupied()){
                if(caseMap.get(prochainePosition).getPiece().getCouleur().equals(aCase.getPiece().getCouleur())){
                    break;
                }
                mouvementsPossibles.add(prochainePosition);
                break;
            }
            mouvementsPossibles.add(prochainePosition);
            prochainePosition = construirePosition(prochainePosition, decalageColonne, decalageRangee);
        }
    }

    private List<Position> getMouvementsTour(Case aCase, Plateau plateau) {
        List<Position> mouvementsPossibles = Collections.emptyList();
        Map<Position, Case> caseMap = plateau.getPositionCaseMap();

        getMouvementsColonnes(mouvementsPossibles, caseMap, aCase, -1);
        getMouvementsColonnes(mouvementsPossibles, caseMap, aCase, 1);
        getMouvementsRangees(mouvementsPossibles, caseMap, aCase, -1);
        getMouvementsRangees(mouvementsPossibles, caseMap, aCase, 1);

        return mouvementsPossibles;
    }

    private void getMouvementsRangees(List<Position> mouvementsPossibles,
                                      Map<Position, Case> caseMap,
                                      Case aCase,
                                      int decalage) {
        Position courante = aCase.getPosition();
        Position prochainePosition = construirePosition(courante, 0, decalage);
        while (caseMap.containsKey(prochainePosition)) {
            if (caseMap.get(prochainePosition).isOccupied()) {
                if (caseMap.get(prochainePosition).getPiece().getCouleur().equals(aCase.getPiece().getCouleur())) {
                    break;
                }
                mouvementsPossibles.add(prochainePosition);
                break;
            }
            mouvementsPossibles.add(prochainePosition);
            prochainePosition = construirePosition(prochainePosition,
                    0, decalage);
        }
    }

    private void getMouvementsColonnes(
            List<Position> mouvementsPossibles,
            Map<Position, Case> caseMap,
            Case aCase,
            int decalage) {
        Position courante = aCase.getPosition();
        Position prochainePosition = construirePosition(courante, decalage, 0);
        while (caseMap.containsKey(prochainePosition)) {
            if (caseMap.get(prochainePosition).isOccupied()) {
                if (caseMap.get(prochainePosition).getPiece().getCouleur().equals(aCase.getPiece().getCouleur())) {
                    mouvementsPossibles.add(prochainePosition);
                    break;
                }
                mouvementsPossibles.add(prochainePosition);
                break;
            }
            mouvementsPossibles.add(prochainePosition);
            prochainePosition = construirePosition(prochainePosition, decalage, 0);
        }
    }

    private List<Position> getMouvementsReine(Case aCase, Plateau plateau) {
        List<Position> mouvementsPossibles = Collections.emptyList();
        mouvementsPossibles.addAll(getMouvementsFou(aCase, plateau));
        mouvementsPossibles.addAll(getMouvementsTour(aCase, plateau));
        return mouvementsPossibles;
    }

    private List<Position> getMouvementsCavalier(Case aCase, Plateau plateau) {
        List<Position> mouvementsPossibles = Collections.emptyList();

        getMouvementsJumps(mouvementsPossibles,
                plateau.getPositionCaseMap(), aCase, -2, -1);
        getMouvementsJumps(mouvementsPossibles,
                plateau.getPositionCaseMap(), aCase, -2, 1);
        getMouvementsJumps(mouvementsPossibles,
                plateau.getPositionCaseMap(), aCase, 2, -1);
        getMouvementsJumps(mouvementsPossibles,
                plateau.getPositionCaseMap(), aCase, 2, 1);
        getMouvementsJumps(mouvementsPossibles,
                plateau.getPositionCaseMap(), aCase, -1, -2);
        getMouvementsJumps(mouvementsPossibles,
                plateau.getPositionCaseMap(), aCase, -1, 2);
        getMouvementsJumps(mouvementsPossibles,
                plateau.getPositionCaseMap(), aCase, 1, -2);
        getMouvementsJumps(mouvementsPossibles,
                plateau.getPositionCaseMap(), aCase, 1, 2);

        return mouvementsPossibles;
    }

    private void getMouvementsJumps(List<Position> mouvementsPossibles,
                                    Map<Position, Case> caseMap,
                                    Case aCase, int decalageColonne, int decalageRangee){
        Position courante = aCase.getPosition();
        Position prochainePosition = construirePosition(courante, decalageColonne, decalageRangee);
        if(caseMap.containsKey(prochainePosition)){
            if(caseMap.get(prochainePosition).isOccupied()){
                if(caseMap.get(prochainePosition).getPiece().getCouleur().equals(aCase.getPiece().getCouleur())){
                    return;
                }
                mouvementsPossibles.add(prochainePosition);
                return;
            }
            mouvementsPossibles.add(prochainePosition);
        }
    }

    private List<Position> getMouvementsRoi(Case aCase, Plateau plateau) {
        List<Position> mouvementsPossibles = Collections.emptyList();
        Position courante = aCase.getPosition();
        mouvementsPossibles.addAll(getMouvementsFou(aCase, plateau));
        mouvementsPossibles.addAll(getMouvementsTour(aCase, plateau));

        return mouvementsPossibles.stream().filter((mouvement) -> (
                Math.abs(mouvement.getColonne().ordinal() - courante.getColonne().ordinal()) == 1 &&
                        Math.abs(mouvement.getRang() - courante.getRang()) == 1
                )).collect(Collectors.toList());
    }

    private Position construirePosition(Position positionCourante, int decalageColonne, int decalageRangee) {
        final Colonne[] colonnes = Colonne.values();
        Integer colonneCourante = positionCourante.getColonne().ordinal();
        return new Position(colonnes[colonneCourante
                + decalageColonne], positionCourante.getRang() + decalageRangee);
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
