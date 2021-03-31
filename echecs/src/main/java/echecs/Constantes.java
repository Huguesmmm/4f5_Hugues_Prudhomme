package echecs;

public class Constantes {
	// ------ CONSTANTES DU PROGRAMME ------
	// partie
	public static final int DIMENSION_PLATEAU = 8;

	// ------ FICHIER JSON ------
	// partie
	public static final String[] IDS_MODELES_TESTS = {"test01","test02","test03","complet"};
	// leaderboard
	public static final String[] JSON_MODELES_TESTS = {"modeleJson1","modeleJson2","modeleJson3"};

	// ------ VUE XML ------
	// accueil
	public static final String CHEMIN_ACCUEIL_FXML = "/accueil/structure.xml";
	// partie
	public static final String CHEMIN_PARTIE_LOCALE_FXML = "/partie/locale/structure.xml";
	// leaderboard
	public static final String CHEMIN_LEADERBOARD_FXML = "/leaderboard/structure.xml";

	// ----- VUE TAILLE -----
	// partie
	public static final int TAILLE_CASE = 80;
	public static final int SIZE_PARTIE_PIXELS = 740;
	// leaderboard
	public static final int LARGEUR_PARAMETRES_PIXELS = 300;
	public static final int HAUTEUR_PARAMETRES_PIXELS = 520;

	public static final int LARGEUR_PIXELS = 600;
	public static final int HAUTEUR_PIXELS= 800;

	public static final int LARGEUR_PARAMETRES_PIXELS_MIN = 250;
	public static final int HAUTEUR_PARAMETRES_PIXELS_MIN = 500;

	public static final int LARGEUR_PARAMETRES_PIXELS_MAX = 350;
	public static final int HAUTEUR_PARAMETRES_PIXELS_MAX = 540;

	public static final int LARGEUR_PIXELS_MIN = 400;
	public static final int HAUTEUR_PIXELS_MIN = 600;

	// ------ VUE STYLE CSS ------
	// partie
	public static final String STYLE_BLACK_OCCUPIED = "-fx-font-size:30; -fx-background-color: #4b7399;";
	public static final String STYLE_WHITE_OCCUPIED = "-fx-font-size:30; -fx-background-color: #eae9d2;";
	public static final String STYLE_WHITE_UNOCCUPIED = "-fx-background-color: #eae9d2";
	public static final String STYLE_BLACK_UNOCCUPIED = "-fx-background-color: #4b7399";


	// ------ RESSOURCES ------
	// partie - images
	public static final String CHEMIN_IMAGES = "/resources/images/";

}
