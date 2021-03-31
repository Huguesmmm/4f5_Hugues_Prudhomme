package echecs.pages.partie;

import echecs.pages.partie.afficheurs.AfficheurPartieLocale;
import echecs.pages.partie.controleurs.ControleurPartieLocale;
import echecs.pages.partie.modeles.PartieLocale;
import echecs.pages.partie.vues.VuePartieLocale;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ntro.debogage.DoitEtre;
import ntro.debogage.J;
import ntro.javafx.ChargeurDeVue;
import ntro.javafx.Initialisateur;
import ntro.mvc.controleurs.FabriqueControleur;
import ntro.mvc.modeles.EntrepotDeModeles;

import java.util.Random;

import static echecs.Constantes.*;

public class PagePartieLocale extends Application {
	
	static {

		Initialisateur.initialiser();
		
		J.appel(PagePartieLocale.class);
	}

	private Random alea = new Random();

	public static void main(String[] args) {
		J.appel(PagePartieLocale.class);
		launch(args);
		System.out.println("Hello");
	}


	@Override
	public void start(Stage fenetrePrincipale) throws Exception {
		J.appel(this);

		ChargeurDeVue<VuePartieLocale> chargeur;
		chargeur = new ChargeurDeVue<VuePartieLocale>(CHEMIN_PARTIE_LOCALE_FXML);

		VuePartieLocale vue = chargeur.getVue();

		String idModeleTest = "complet";
		PartieLocale partie = EntrepotDeModeles.obtenirModele(PartieLocale.class, idModeleTest);

		AfficheurPartieLocale afficheur = new AfficheurPartieLocale();

		DoitEtre.nonNul(vue);

		FabriqueControleur.creerControleur(ControleurPartieLocale.class, partie, vue, afficheur);

		Scene scene = chargeur.nouvelleScene(SIZE_PARTIE_PIXELS, SIZE_PARTIE_PIXELS);
		fenetrePrincipale.setScene(scene);
		fenetrePrincipale.setMinHeight(SIZE_PARTIE_PIXELS);
		fenetrePrincipale.setMinWidth(SIZE_PARTIE_PIXELS);
		fenetrePrincipale.show();
	}
	
}
