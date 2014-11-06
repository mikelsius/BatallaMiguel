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
    private static final int TEMPSESPERA = 100;
    private int filesTerreny = 0;
    public Principal pantalla;
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
            ex.soldatsFormacio(filesTerreny);
            pintaImatges(exercits.size() - 1);
        }
    }
    private void pintaImatges(final int numExercit) {

        List<Soldat> imatges = exercits.get(numExercit).getSoldats();
        for (Soldat un : imatges) {
            pantalla.add(un.getGImage());
        }
    }
    public void batalla(){
        while (exercits.get(0).getNumeroDeSoldats() > 0
                && exercits.get(1).getNumeroDeSoldats() > 0) {

            exercits.get(0).moure();
            exercits.get(1).moure();
            pantalla.pause(TEMPSESPERA);

            // Comprovar si s'han de reduïr les files
            int minim = Math.min(exercits.get(0).getNumeroDeSoldats(),
                                 exercits.get(1).getNumeroDeSoldats());

            if (minim < FILESTERRENY) {
                exercits.get(0).setFilesExercit(minim);
                exercits.get(1).setFilesExercit(minim);
            }
        }
    }

}
