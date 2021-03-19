package echecs.pages.partie.modeles;

import echecs.enumerations.Couleur;
import echecs.enumerations.TypePiece;

public class Piece implements PieceLectureSeule{
	private Couleur couleur;
	private TypePiece typePiece;
	private transient Position position;

	public Couleur getCouleur() {
		return couleur;
	}
	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}
	public TypePiece getTypePiece() {
		return typePiece;
	}
	public void setTypePiece(TypePiece typePiece) {
		this.typePiece = typePiece;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}

	

}
