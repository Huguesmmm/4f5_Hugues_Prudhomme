package echec.pages.partie.modeles;

import echec.enumerations.Couleur;
import ntro.debogage.J;

public class Case implements CaseLectureSeule{
	private Piece piece;

	private Couleur couleur;
	private Position position;

	public Couleur getCouleur() {
		J.appel(this);
		return couleur;
	}
	
	public void setCouleur(Couleur couleur) {
		J.appel(this);
		this.couleur = couleur;
	}
	
	public Position getPosition() {
		J.appel(this);
		return position;
	}
	
	public void setPosition(Position position) {
		J.appel(this);
		this.position = position;
	}
	
	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}
}
