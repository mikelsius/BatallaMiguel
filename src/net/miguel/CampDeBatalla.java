/**
 *.
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
    /**
     * files del terreny on van soldats.
     */
    private static final int FILESTERRENY = 6;
    /**
     * temps de espera entre moviments.
     */
    private static final int TEMPSESPERA = 20;
    /**
     * files del terreny.
     */
    private int filesTerreny = 0;
    /**
     * pantalla.
     */
    private Principal pantalla;
    /**
     *
     * @param pant pantalla
     */
    public CampDeBatalla(final Principal pant) {
        pantalla = pant;
        filesTerreny = FILESTERRENY;
        exercits = new ArrayList<Exercit>();
    }
    /**
     *
     * @param ex exercit
     * @param posicioi posicion inicial
     * @param posiciof posicio final
     */
    public final void afegirExercit(final Exercit ex,
            final int posicioi, final int posiciof) {
        if (ex != null) {
            exercits.add(ex);
            ex.setPosicio(posicioi, posiciof);
            ex.soldatsFormacio(filesTerreny);
            pintaImatges(exercits.size() - 1);
        }
    }
    /**
     *
     * @param numExercit numero del exercit.
     */
    private void pintaImatges(final int numExercit) {

        List<Soldat> imatges = exercits.get(numExercit).getSoldats();
        for (Soldat un : imatges) {
            pantalla.add(un.getGImage());
        }
    }
    /**
     * Batalla!
     */
    public final void batalla() {
        while (exercits.get(0).getNumeroDeSoldats() > 0
                && exercits.get(1).getNumeroDeSoldats() > 0) {

            int esmou1 = exercits.get(0).moure();
            //Despres de moure el exercit hem de mirar
            //si han tocat algun enemic!
            exercits.get(0).atacar(exercits.get(1));
            pantalla.pause(TEMPSESPERA);
            int esmou2 = exercits.get(1).moure();
            exercits.get(1).atacar(exercits.get(0));
            pantalla.pause(TEMPSESPERA);

            // Comprovar si s'han de reduïr les files
            int minim = Math.min(exercits.get(0).getNumeroDeSoldats(),
                                 exercits.get(1).getNumeroDeSoldats());
            if (esmou1 == 0) {
                //Cap es mou, ara hem de definir el nou origen i desti.
                //i despres recolocarlos.
                if (exercits.get(0).calculaDireccio() == 1) {
                    exercits.get(0).setPosicio(pantalla.getPosInicial(),
                            pantalla.getAmplada());
                } else {
                    exercits.get(0).setPosicio(pantalla.getAmplada(),
                            pantalla.getPosInicial());
                }
                exercits.get(0).soldatsFormacio(minim);
            }
            if (esmou2 == 0) {
                if (exercits.get(1).calculaDireccio() == -1) {
                    exercits.get(1).setPosicio(pantalla.getAmplada(),
                            pantalla.getPosInicial());
                } else {
                    exercits.get(1).setPosicio(pantalla.getPosInicial(),
                            pantalla.getAmplada());
                }
                exercits.get(1).soldatsFormacio(minim);
            }
        }
    }
}
