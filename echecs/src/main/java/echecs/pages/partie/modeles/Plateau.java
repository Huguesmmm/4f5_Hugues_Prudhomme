package echecs.pages.partie.modeles;

import echecs.enumerations.Colonne;
import echecs.Constantes;
import echecs.enumerations.Couleur;
import ntro.debogage.J;

import java.util.ArrayList;
import java.util.List;

public class Plateau implements PlateauLectureSeule {
    private transient Case[][] plateauCases = new Case[Constantes.DIMENSION_PLATEAU][Constantes.DIMENSION_PLATEAU];
    protected List<Case> casesOccupees;

    public void apresCreation() {
        // création du tableau de toutes les cases
        for (int i = 0; i < plateauCases.length; i++) {
            int indexColonne = 0;
            Couleur altCouleur = (i % 2 == 0) ? Couleur.BLANC : Couleur.NOIR;
            for (Colonne colonne : Colonne.values()) {
                Case nouvelleCase = new Case();
                nouvelleCase.setCouleur(altCouleur);
                nouvelleCase.setPosition(new Position(colonne, i));
                plateauCases[i][indexColonne] = nouvelleCase;
                altCouleur = (altCouleur == Couleur.NOIR) ? Couleur.BLANC : Couleur.NOIR;
                indexColonne++;
            }
        }

        // création de la liste des cases occupées
        casesOccupees = new ArrayList<>();
    }

    public void apresChargementJson() {
        // case occupé est une liste pleine
        for(Case aCase : casesOccupees){
            
        }
    }


    @Override
    public List<CaseLectureSeule> getCasesOccupees() {
        J.appel(this);

        List<CaseLectureSeule> casesOccupeesLectureSeule = new ArrayList<>();

        for (Case aCase : casesOccupees) {
            casesOccupeesLectureSeule.add((CaseLectureSeule) aCase);
        }

        return casesOccupeesLectureSeule;
    }

    public void setCasesOccupees(List<Case> cases) {
        this.casesOccupees = cases;
    }

    public CaseLectureSeule[][] getPlateauCases() {
        J.appel(this);

        CaseLectureSeule[][] casesLectureSeules =
                new CaseLectureSeule[Constantes.DIMENSION_PLATEAU][Constantes.DIMENSION_PLATEAU];

        for(int i = 0; i < casesLectureSeules.length; i++){
            for(int j = 0; j < casesLectureSeules[i].length; j++){
                casesLectureSeules[i][j] = plateauCases[i][j];
            }
        }
        return casesLectureSeules;
    }

    public void setPlateauCases(Case[][] plateauCases) {
        this.plateauCases = plateauCases;
    }
}
