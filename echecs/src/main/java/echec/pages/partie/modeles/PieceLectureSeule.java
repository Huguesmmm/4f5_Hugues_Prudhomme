package echec.pages.partie.modeles;

import echec.enumerations.Couleur;
import echec.enumerations.TypePiece;

public interface PieceLectureSeule {
	Couleur getCouleur();
	TypePiece getTypePiece();
	Position getPosition();
}
