package echecs.pages.partie;

import static echec.Constantes.IDS_MODELES_TESTS;
import java.util.Random;
import echec.pages.partie.modeles.Case;
import echec.pages.partie.modeles.PartieLocale;
import javafx.application.Application;
import javafx.stage.Stage;
import ntro.debogage.J;
import ntro.mvc.modeles.EntrepotDeModeles;
import ntro.systeme.Systeme;

public class PagePartieLocale extends Application {
	private Random alea = new Random();
	@Override
	public void start(Stage fenetrePrincipale) throws Exception {
		J.appel(this);
		
		String idModeleTest = IDS_MODELES_TESTS[alea.nextInt(IDS_MODELES_TESTS.length)];
		PartieLocale partie = EntrepotDeModeles.obtenirModele(PartieLocale.class, idModeleTest);
		
		J.valeurs(partie.getId());
		
		Systeme.quitter();
	}
	
}
