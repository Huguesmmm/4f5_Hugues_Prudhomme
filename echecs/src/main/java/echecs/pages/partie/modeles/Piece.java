package echecs.pages.partie.modeles;

import echecs.enumerations.Couleur;
import echecs.enumerations.TypePiece;

public class Piece implements PieceLectureSeule{
	private Couleur couleur;
	private TypePiece typePiece;
	private Position position;

	@Override
	public Couleur getCouleur() {
		return couleur;
	}

	@Override
	public TypePiece getTypePiece() {
		return typePiece;
	}

	@Override
	public Position getPosition() {
		return position;
	}

}
