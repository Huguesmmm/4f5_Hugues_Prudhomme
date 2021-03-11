package echecs.pages.partie.modeles;

import echecs.enumerations.Colonne;

public class Position implements PositionLectureSeule{
	private Colonne colonne;
	private int rang;

	public Position(Colonne colonne, int rang){
		this.colonne = colonne;
		this.rang = rang;
	}


	public Colonne getColonne() {
		return colonne;
	}
	
	public void setColonne(Colonne colonne) {
		this.colonne = colonne;
	}
	
	public int getRang() {
		return rang;
	}
	
	public void setRang(int rang) {
		this.rang = rang;
	}

	@Override
	public String toString() {
		return "Position : " + colonne + rang;
	}
}
