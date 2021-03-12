package echecs.pages.partie.modeles;

import echecs.enumerations.Couleur;
import ntro.debogage.J;

public class Case implements CaseLectureSeule{

	private transient boolean estOccupee;
	private Piece piece;
	private transient final Couleur couleur;
	private final Position position;

	public Case(Couleur couleur, Position position) {
		this.couleur = couleur;
		this.position = position;
	}

	public void apresChargementJson(){
		J.appel(this);

	}
	
	public Couleur getCouleur() {
		J.appel(this);
		return couleur;
	}
	
	public Position getPosition() {
		J.appel(this);
		return position;
	}
	
	public Piece getPiece() {
		J.appel(this);
		return piece;
	}

	public void setPiece(Piece piece) {
		J.appel(this);
		this.piece = piece;
	}
}
