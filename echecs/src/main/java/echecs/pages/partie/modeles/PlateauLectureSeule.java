package echecs.pages.partie.modeles;

import echecs.enumerations.Couleur;

import java.util.List;
import java.util.Map;

public interface PlateauLectureSeule {
	List<CaseLectureSeule> getCasesOccupees();
	CaseLectureSeule[][] getPlateauCases();
	Map<Position, Case> getPositionCaseMap();
	Couleur getCouleurCourante();
	String toString();
}
