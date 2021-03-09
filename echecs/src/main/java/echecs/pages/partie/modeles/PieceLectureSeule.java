package echecs.pages.partie.modeles;

import echecs.enumerations.Couleur;
import echecs.enumerations.TypePiece;

public interface PieceLectureSeule {
	Couleur getCouleur();
	TypePiece getTypePiece();
	Position getPosition();
}
