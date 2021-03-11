package echecs.pages.partie.modeles;

import echecs.enumerations.Couleur;
import ntro.debogage.J;

public class Case implements CaseLectureSeule{

	private transient boolean estOccupee;
	private Piece piece;
	private transient Couleur couleur;
	private Position position;

	public void apresChargementJson(){
		J.appel(this);

	}
	
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
		J.appel(this);
		return piece;
	}

	public void setPiece(Piece piece) {
		J.appel(this);
		this.piece = piece;
	}
}
