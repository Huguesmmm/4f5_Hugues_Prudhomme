package echecs.pages.partie.modeles;

import echecs.enumerations.Couleur;
import ntro.debogage.J;

public class Case implements CaseLectureSeule{

	private transient boolean isActive;
	private transient boolean isOccupied;
	private Piece piece;
	private transient final Couleur couleur;
	private final Position position;

	public Case(Couleur couleur, Position position) {
		this.couleur = couleur;
		this.position = position;
		this.isActive = false;
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
		this.isOccupied = true;
	}

	public void reset(){
		this.isOccupied = false;
		this.isActive = false;
		this.piece = null;
	}

	public boolean isOccupied(){
		return isOccupied;
	}
	public void setOccupied(boolean occupied){
		isOccupied = occupied;
	}

	@Override
	public String toString() {
		if(this.isOccupied){
			return "Case{" +
					"estOccupee=" + isOccupied +
					", piece( " + piece.getTypePiece().name() + piece.getCouleur().name() + " )" +
					", couleur=" + couleur +
					", position=" + position.toString() +
					'}';
		}else{
			return "Case{" +
					"estOccupee=" + isOccupied +
					", piece( vide )" +
					", couleur=" + couleur +
					", position=" + position.toString() +
					'}';
		}
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean active) {
		isActive = active;
	}

	public void synchroniserPosition(){
		if(isOccupied){
			piece.setPosition(position);
		}
	}
}
