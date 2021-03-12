package echecs.pages.partie.modeles;

import java.util.List;

public interface PlateauLectureSeule {
	List<CaseLectureSeule> getCasesOccupees();
	CaseLectureSeule[][] getPlateauCases();
	String toString();
}
