package echecs.pages.partie;

import echecs.pages.partie.modeles.PartieLocale;
import javafx.application.Application;
import javafx.stage.Stage;
import ntro.debogage.J;
import ntro.javafx.Initialisateur;
import ntro.mvc.modeles.EntrepotDeModeles;
import ntro.systeme.Systeme;

import java.util.Random;

import static echecs.Constantes.IDS_MODELES_TESTS;

public class PagePartieLocale extends Application {
	private Random alea = new Random();
	
	static {

		Initialisateur.initialiser();
		
		J.appel(PagePartieLocale.class);
	}
	
	public static void main(String[] args) {
		J.appel(PagePartieLocale.class);
		launch(args);
		System.out.println("Hello");
	}
	
	@Override
	public void start(Stage fenetrePrincipale) throws Exception {
		J.appel(this);

		String idModeleTest = IDS_MODELES_TESTS[alea.nextInt(IDS_MODELES_TESTS.length)];
		try {
			PartieLocale partie = EntrepotDeModeles.obtenirModele(PartieLocale.class, idModeleTest);
			J.valeurs(partie.getId());
			// afficher la liste de cases occupees
			System.out.println(partie.getPlateau().getCasesOccupees().get(0).getCouleur());



		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}

		System.out.println("Hello");

		Systeme.quitter();
	}
	
}
