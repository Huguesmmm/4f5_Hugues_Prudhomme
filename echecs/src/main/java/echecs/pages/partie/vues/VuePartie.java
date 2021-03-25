package echecs.pages.partie.vues;

import echecs.commandes.peut_jouer.PeutJouerPourEnvoie;
import echecs.enumerations.Colonne;
import echecs.enumerations.Couleur;
import echecs.pages.partie.modeles.CaseLectureSeule;
import echecs.pages.partie.modeles.Piece;
import echecs.pages.partie.modeles.Position;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.mvc.Vue;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static echecs.Constantes.*;

public abstract class VuePartie implements Vue, Initializable {
    @FXML
    private VBox conteneurPlateau;

    private Button[][] cases = new Button[DIMENSION_PLATEAU][DIMENSION_PLATEAU];
    private List<Button> casesOccupees = new ArrayList<Button>();
    private PeutJouerPourEnvoie peutJouerPourEnvoie;
    // rajouter couleur courante

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        J.appel(this);
        DoitEtre.nonNul(conteneurPlateau);
        conteneurPlateau.setFillWidth(true);
    }
    public void creerPlateau(){
        J.appel(this);
        creerColonnes();
    }

    public void creerColonnes(){
        J.appel(this);

        for(int indiceRangee = 0; indiceRangee < DIMENSION_PLATEAU; indiceRangee++){
            HBox rangee = creerRangee(indiceRangee);
            conteneurPlateau.getChildren().add(rangee);
        }
    }
    public HBox creerRangee(int indiceRangee){
        J.appel(this);
        HBox rangee = new HBox();
        for(int indiceColonne = 0; indiceColonne < DIMENSION_PLATEAU; indiceColonne++){
            Button aCase = creerCase();
            cases[indiceColonne][indiceRangee] = aCase;
            rangee.getChildren().add(aCase);
        }
        return rangee;
    }
    public Button creerCase(){
        J.appel(this);
        Button aCase = new Button();

        aCase.setMinSize(TAILLE_CASE, TAILLE_CASE);
        aCase.setMaxSize(TAILLE_CASE, TAILLE_CASE);

        return aCase;
    }

    @Override
    public void obtenirCommandesPourEnvoi() {
        J.appel(this);
    }

    @Override
    public void installerCapteursEvenementsUsager() {
        J.appel(this);

        for(int i = 0; i < cases.length; i++){
            for(int j = 0; j < cases[i].length; j++){
                Colonne[] colonnes = Colonne.values();
                final Colonne colonne = colonnes[j];
                final int indiceRangee = DIMENSION_PLATEAU - i;
                cases[i][j].setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        J.appel(this);
                        peutJouerPourEnvoie.setPosition(new Position(colonne, indiceRangee));
                        peutJouerPourEnvoie.envoyerCommande();
                    }
                });
            }
        }

    }

    @Override
    public void verifierCommandesPossibles() {
        J.appel(this);
    }

    public boolean siIndicesValides(int indiceColonne, int indiceRangee){
        J.appel(this);
        boolean siValide = false;
        if(indiceColonne >= 0 && indiceColonne < cases.length){
            siValide = indiceRangee >= 0 && indiceRangee < cases[indiceColonne].length;
        }
        return siValide;
    }

    public void afficherCase(int indiceColonne, int indiceRangee, CaseLectureSeule aCaseTab){
        J.appel(this);
        if(siIndicesValides(indiceColonne, indiceRangee)){
            Button aCase = cases[indiceColonne][indiceRangee];
            Couleur couleur = aCaseTab.getCouleur();
            Position position = aCaseTab.getPosition();
            Piece piece = aCaseTab.getPiece();
            boolean occupied = aCaseTab.isOccupied();

            switch (couleur){
                case NOIR:
                    aCase.setStyle(null);
                    aCase.setStyle(STYLE_BLACK_UNOCCUPIED);
                    break;
                case BLANC:
                    aCase.setStyle(null);
                    aCase.setStyle(STYLE_WHITE_UNOCCUPIED);
                    break;
            }

            if(occupied){
                switch (couleur){
                    case NOIR:
                        aCase.setStyle(null);
                        aCase.setStyle(STYLE_BLACK_OCCUPIED);
                        break;
                    case BLANC:
                        aCase.setStyle(null);
                        aCase.setStyle(STYLE_WHITE_OCCUPIED);
                        break;
                }
                switch (piece.getCouleur()){
                    case BLANC:
                        switch (piece.getTypePiece()){
                            case PION:
                                aCase.setText("\u2659");
                                break;
                            case TOUR:
                                aCase.setText("\u2656");
                                break;
                            case CAVALIER:
                                aCase.setText("\u2658");
                                break;
                            case FOU:
                                aCase.setText("\u2657");
                                break;
                            case ROI:
                                aCase.setText("\u2654");
                                break;
                            case REINE:
                                aCase.setText("\u2655");
                                break;
                        }
                        break;
                    case NOIR:
                        switch (piece.getTypePiece()){
                            case PION:
                                aCase.setText("\u265F");
                                break;
                            case TOUR:
                                aCase.setText("\u265C");
                                break;
                            case CAVALIER:
                                aCase.setText("\u265E");
                                break;
                            case FOU:
                                aCase.setText("\u265D");
                                break;
                            case ROI:
                                aCase.setText("\u265A");
                                break;
                            case REINE:
                                aCase.setText("\u265B");
                                break;
                        }
                }

            }else {
                aCase.setText(position.toString());
            }


        }
    }
}
