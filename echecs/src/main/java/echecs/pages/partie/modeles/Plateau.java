package echecs.pages.partie.modeles;

import echecs.enumerations.Colonne;
import echecs.enumerations.Couleur;
import ntro.debogage.J;

import java.util.ArrayList;
import java.util.List;

import static echecs.Constantes.DIMENSION_PLATEAU;

public class Plateau implements PlateauLectureSeule {
    private transient Case[][] plateauCases = new Case[DIMENSION_PLATEAU][DIMENSION_PLATEAU];
    protected List<Case> casesOccupees;

    public void apresCreation() {
        J.appel(this);
        // création du tableau de toutes les cases
        initialiserPlateauCases();
        ajouterOccupeesPlateau();
        // création de la liste des cases occupées
        casesOccupees = new ArrayList<>();
    }

    public void apresChargementJson() {
        J.appel(this);
        initialiserPlateauCases();
        ajouterOccupeesPlateau();
        // case occupé est une liste pleine
        for(int indiceCase = 0; indiceCase < casesOccupees.size(); indiceCase++){
            Case aCase = casesOccupees.get(indiceCase);
            aCase.apresChargementJson();
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
        J.appel(this);
        this.casesOccupees = cases;
    }

    public CaseLectureSeule[][] getPlateauCases() {
        J.appel(this);

        CaseLectureSeule[][] casesLectureSeules =
                new CaseLectureSeule[DIMENSION_PLATEAU][DIMENSION_PLATEAU];

        for(int i = 0; i < casesLectureSeules.length; i++){
            for(int j = 0; j < casesLectureSeules[i].length; j++){
                casesLectureSeules[i][j] = plateauCases[i][j];
            }
        }
        return casesLectureSeules;
    }

    public void setPlateauCases(Case[][] plateauCases) {
        J.appel(this);
        this.plateauCases = plateauCases;
    }

    private void initialiserPlateauCases(){
        for (int i = 0; i < plateauCases.length; i++) {
            int indexColonne = 0;
            Couleur altCouleur = (i % 2 == 0) ? Couleur.BLANC : Couleur.NOIR;
            for (Colonne colonne : Colonne.values()) {
                Case nouvelleCase = new Case(altCouleur, new Position(colonne, DIMENSION_PLATEAU - i));
                plateauCases[i][indexColonne] = nouvelleCase;
                altCouleur = (altCouleur == Couleur.NOIR) ? Couleur.BLANC : Couleur.NOIR;
                indexColonne++;
            }
        }
    }

    public void ajouterOccupeesPlateau(){
        try {
            for (Case aCase : casesOccupees) {
                int indiceColonne = aCase.getPosition().getColonne().ordinal();
                int indiceRangee = aCase.getPosition().getRang();
                plateauCases[DIMENSION_PLATEAU - indiceRangee][indiceColonne].setPiece(aCase.getPiece());
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String toString() {
        String plateauReturned = "";

        for(Case[] rangee : plateauCases){
            for(Case aCase : rangee){
                plateauReturned += aCase.toString();
                plateauReturned += " ";
            }
            plateauReturned += "\n";
        }


        return plateauReturned;
    }
}
