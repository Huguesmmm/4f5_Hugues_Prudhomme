package echecs.pages.partie.vues;

import echecs.Constantes;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.mvc.Vue;

import java.net.URL;
import java.util.ResourceBundle;

public class VuePartie implements Vue, Initializable {
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
}
