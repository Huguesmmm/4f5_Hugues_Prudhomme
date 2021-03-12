package echecs.pages.partie.vues;

import echecs.Constantes;
import echecs.enumerations.Couleur;
import echecs.pages.partie.modeles.CaseLectureSeule;
import echecs.pages.partie.modeles.Piece;
import echecs.pages.partie.modeles.Position;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.mvc.Vue;

import java.net.URL;
import java.util.ResourceBundle;

public abstract class VuePartie implements Vue, Initializable {
    @FXML
    private VBox conteneurPlateau;

    private Button[][] cases;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        J.appel(this);
        DoitEtre.nonNul(conteneurPlateau);
    }
    public void creerPlateau(){
        J.appel(this);
        creerColonnes();
    }

    public void creerColonnes(){
        J.appel(this);

        for(int indiceRangee = 0; indiceRangee < Constantes.DIMENSION_PLATEAU; indiceRangee++){
            HBox rangee = creerRangee(indiceRangee);
            conteneurPlateau.getChildren().add(rangee);
        }
    }
    public HBox creerRangee(int indiceRangee){
        J.appel(this);
        HBox rangee = new HBox();
        for(int indiceColonne = 0; indiceColonne < Constantes.DIMENSION_PLATEAU; indiceColonne++){
            Button aCase = creerCase();
            cases[indiceColonne][indiceColonne] = aCase;
            rangee.getChildren().add(aCase);
        }
        return rangee;
    }
    public Button creerCase(){
        J.appel(this);
        Button aCase = new Button();

        aCase.setMinSize(Constantes.TAILLE_CASE, Constantes.TAILLE_CASE);
        aCase.setMaxSize(Constantes.TAILLE_CASE, Constantes.TAILLE_CASE);

        return aCase;
    }

    @Override
    public void obtenirCommandesPourEnvoi() {
        J.appel(this);
    }

    @Override
    public void installerCapteursEvenementsUsager() {
        J.appel(this);
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
            switch (couleur){
                case NOIR:
                    aCase.setBackground(new Background(new BackgroundFill(Color.BLACK, null, null)));
                    break;
                case BLANC:
                    aCase.setBackground(new Background(new BackgroundFill(Color.WHEAT, null, null)));
            }
        }
    }
}
