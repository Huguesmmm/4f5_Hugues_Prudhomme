package echecs.pages.partie.modeles;

import echecs.enumerations.Colonne;

import java.util.Objects;

public class Position implements PositionLectureSeule{
	private final Colonne colonne;
	private final int rang;

	public Position(Colonne colonne, int rang){
		this.colonne = colonne;
		this.rang = rang;
	}


	public Colonne getColonne() {
		return colonne;
	}
	
	public int getRang() {
		return rang;
	}

	@Override
	public String toString() {

		return ""+ colonne + rang;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Position)) return false;
		Position position = (Position) o;
		return rang == position.rang && colonne == position.colonne;
	}

	@Override
	public int hashCode() {
		return Objects.hash(colonne, rang);
	}
}
