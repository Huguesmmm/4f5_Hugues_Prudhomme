package echec.pages.partie.modeles;

import echec.enumerations.Couleur;
import echec.enumerations.TypePiece;

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
