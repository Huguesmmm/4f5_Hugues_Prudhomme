package echecs.pages.partie.modeles;

import ntro.debogage.J;
import ntro.mvc.modeles.Modele;

public class Partie<PLS extends PartieLectureSeule> extends Modele<PLS> implements PartieLectureSeule {

	protected Plateau plateau;

	@Override
	public void apresCreation() {
		J.appel(this);
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

	public PlateauLectureSeule getPlateau(){
		J.appel(this);
		return (PlateauLectureSeule) plateau;
	}

	public void setPlateau(Plateau plateau){
		J.appel(this);
		this.plateau = plateau;
	}
}
