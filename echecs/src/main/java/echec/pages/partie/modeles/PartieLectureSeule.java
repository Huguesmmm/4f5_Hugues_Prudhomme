package echec.pages.partie.modeles;

import java.util.List;

import ntro.mvc.modeles.ModeleLectureSeule;

public interface PartieLectureSeule extends ModeleLectureSeule{
	List<CaseLectureSeule> getCases();
}
