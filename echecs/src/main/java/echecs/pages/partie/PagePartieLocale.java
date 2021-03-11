package echecs.pages.partie;

import echecs.pages.partie.modeles.CaseLectureSeule;
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

		String idModeleTest = IDS_MODELES_TESTS[alea.nextInt(IDS_MODELES_TESTS.length)];
		try {
			PartieLocale partie = EntrepotDeModeles.obtenirModele(PartieLocale.class, idModeleTest);
			J.valeurs(partie.getId());
			// afficher la liste de cases occupees
			System.out.println(partie.getPlateau().getCasesOccupees().size());
			for(int i = 0; i < partie.getPlateau().getCasesOccupees().size(); i++){
				CaseLectureSeule aCaseOccupee = partie.getPlateau().getCasesOccupees().get(i);

				J.valeurs(aCaseOccupee.getPosition().toString(), aCaseOccupee.getPiece().getTypePiece().name(),
						aCaseOccupee.getPiece().getCouleur().name());
			}
			CaseLectureSeule[][] tabCases = partie.getPlateau().getPlateauCases();

			for(int i = 0; i < tabCases.length; i++){
				for(int j = 0; j < tabCases[i].length; j++){
					CaseLectureSeule aCase = tabCases[i][j];
					System.out.println(aCase.getCouleur().name());
					System.out.println(aCase.getPosition().toString());
					J.valeurs(aCase.getPosition().toString(), aCase.getCouleur().name(), aCase.getPosition().toString());
				}
			}

		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}


		System.out.println("Hello");

		Systeme.quitter();
	}
	
}
