package echecs.pages.partie.modeles;

import echecs.enumerations.Couleur;
import ntro.debogage.J;
import ntro.mvc.modeles.Modele;

import java.util.ArrayList;
import java.util.List;

public class Partie<PLS extends PartieLectureSeule> extends Modele<PLS> implements PartieLectureSeule {

	protected List<Case> cases;
	protected Couleur couleurCourante;
	protected String id;

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
	
	public Couleur getCouleurCourante() {
		J.appel(this);
		return couleurCourante;
	}

	public String getId() {
		J.appel(this);
		return id;
	}
}
