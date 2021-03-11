package echecs.pages.partie.modeles;

import echecs.enumerations.Couleur;
import ntro.debogage.J;
import ntro.mvc.modeles.Modele;

public class Partie<PLS extends PartieLectureSeule> extends Modele<PLS> implements PartieLectureSeule {

	protected int nbCaseOccupees;
	protected Plateau plateau;
	protected Couleur couleurCourante;

	@Override
	public void apresCreation() {
		J.appel(this);

		couleurCourante = Couleur.BLANC;
		initialiserPlateau();
	}

	@Override
	public void apresChargementJson() {
		J.appel(this);

        plateau.apresChargementJson();
	}

	private void initialiserPlateau(){
		J.appel(this);
		plateau = new Plateau();
		plateau.apresCreation();
	}
	
	public Couleur getCouleurCourante() {
		J.appel(this);
		return couleurCourante;
	}
	
	public void setCouleurCourant(Couleur couleurCourante) {
		this.couleurCourante = couleurCourante;
	}

	public PlateauLectureSeule getPlateau(){
		J.appel(this);
		return (PlateauLectureSeule) plateau;
	}

	public void setPlateau(Plateau plateau){
		J.appel(this);
		this.plateau = plateau;
	}

}
