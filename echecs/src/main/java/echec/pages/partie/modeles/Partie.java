package echec.pages.partie.modeles;

import java.util.ArrayList;
import java.util.List;

import echec.enumerations.Couleur;
import ntro.debogage.J;
import ntro.mvc.modeles.Modele;

public class Partie<PLS extends PartieLectureSeule> extends Modele<PLS> implements PartieLectureSeule {

	protected List<Case> cases;
	protected Couleur couleurCourante;

	@Override
	public void apresChargementJson() {
		J.appel(this);
	}

	@Override
	public void apresCreation() {
		J.appel(this);
	}

	@Override
	public List<CaseLectureSeule> getCases() {
		J.appel(this);

		List<CaseLectureSeule> casesLectureSeule = new ArrayList<>();

		for (Case cs : cases) {
			casesLectureSeule.add((CaseLectureSeule) cs);
		}

		return casesLectureSeule;
	}

}
