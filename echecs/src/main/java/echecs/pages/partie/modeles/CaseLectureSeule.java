package echecs.pages.partie.modeles;

import echecs.enumerations.Couleur;

public interface CaseLectureSeule {
	Piece getPiece();
	Couleur getCouleur();
	Position getPosition();
	String toString();
	boolean isOccupied();
}
