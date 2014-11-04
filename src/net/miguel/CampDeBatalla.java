/**
 * 
 */
package net.miguel;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mikel
 *
 */
public class CampDeBatalla {
	/**
	 * Araylist d'exercits.
	 */
	private List<Exercit> exercits;
    private static final int FILESTERRENY = 6;
    private int filesTerreny = 0;
    private Principal pantalla;
	/**
	 * 
	 */
	public CampDeBatalla(final Principal pant) {
		pantalla = pant;
		filesTerreny = FILESTERRENY;
		exercits = new ArrayList<Exercit>();
	}
	public void afegirExercit(final Exercit ex,
            final int posicioi, final int posiciof){
		if (ex != null) {
            exercits.add(ex);
            ex.setPosicio(posicioi, posiciof);
            ex.soldatsFormacioInicial(filesTerreny);
            pintaImatges(exercits.size() - 1);
        }
	}
	private void pintaImatges(final int numExercit) {

        List<Soldat> imatges = exercits.get(numExercit).getSoldats();
        for (Soldat un : imatges) {
            pantalla.add(un.getGImage());
        }
    }

}
