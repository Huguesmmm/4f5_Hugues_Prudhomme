package echecs.pages.partie.modeles;

import echecs.enumerations.Couleur;
import echecs.enumerations.TypePiece;

public class Piece implements PieceLectureSeule{
	private Couleur couleur;
	private TypePiece typePiece;
	private transient Position position;
	private transient boolean isPremierMouvement = true;

	@Override
	public Couleur getCouleur() {
		return couleur;
	}
	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	@Override
	public TypePiece getTypePiece() {
		return typePiece;
	}
	public void setTypePiece(TypePiece typePiece) {
		this.typePiece = typePiece;
	}
	@Override
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
		setPremierMouvement(false);
	}
	@Override
	public boolean isPremierMouvement() {
		return isPremierMouvement;
	}

	public void setPremierMouvement(boolean premierMouvement) {
		isPremierMouvement = premierMouvement;
	}

}
