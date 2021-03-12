package echecs.pages.partie.afficheurs;

import echecs.pages.partie.modeles.CaseLectureSeule;
import echecs.pages.partie.modeles.PartieLectureSeule;
import echecs.pages.partie.modeles.PlateauLectureSeule;
import echecs.pages.partie.vues.VuePartie;
import ntro.debogage.J;
import ntro.mvc.Afficheur;

import java.util.List;

public abstract class AfficheurPartie <PLS extends PartieLectureSeule,
        V extends VuePartie> extends Afficheur<PLS, V> {

    @Override
    public void initialiserAffichage(PLS partieLectureSeule, V vue) {
        J.appel(this);
        vue.creerPlateau();
    }

    @Override
    public void rafraichirAffichage(PLS partieLectureSeule, V vue) {
        J.appel(this);

        PlateauLectureSeule plateau = partieLectureSeule.getPlateau();
        rafraichirPlateau(plateau, vue);
    }

    public void rafraichirPlateau(PlateauLectureSeule plateau, V vue){
        J.appel(this);
        List<CaseLectureSeule> casesOccupees = plateau.getCasesOccupees();
        CaseLectureSeule[][] cases = plateau.getPlateauCases();

        for(CaseLectureSeule[] rangee : cases){
            for(CaseLectureSeule aCase : rangee){
                int indiceColonne = aCase.getPosition().getColonne().ordinal();
                int indiceRangee = aCase.getPosition().getRang() - 1;
                afficherCase(indiceColonne, indiceRangee,aCase, vue);
            }
        }

    }
    public void afficherCase(int indiceColonne, int indiceRangee, CaseLectureSeule aCase, V vue){
        J.appel(this);
        vue.afficherCase(indiceColonne, indiceRangee, aCase);
    }
}
