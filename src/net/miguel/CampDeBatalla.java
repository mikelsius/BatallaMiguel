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
    private static final int TEMPSESPERA = 50;
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

            int esmou1 = exercits.get(0).moure();
            //Despres de moure el exercit hem de mirar si han tocat algun enemic!
            exercits.get(0).atacar(exercits.get(1));
            pantalla.pause(TEMPSESPERA);
            int esmou2 = exercits.get(1).moure();
            exercits.get(1).atacar(exercits.get(0));
            pantalla.pause(TEMPSESPERA);

            // Comprovar si s'han de reduïr les files
            int minim = Math.min(exercits.get(0).getNumeroDeSoldats(),
                                 exercits.get(1).getNumeroDeSoldats());

            if (minim < filesTerreny) {
                exercits.get(0).setFilesExercit(minim);
                exercits.get(1).setFilesExercit(minim);
            }

            if (esmou1 == 0){ //Cap es mou, ara hem de definir el nou origen i desti.
                                //i despres recolocarlos.
                if (exercits.get(0).calculaDireccio() == 1){
                    exercits.get(0).setPosicio(10,1200);
                }else{
                    exercits.get(0).setPosicio(1200,10);
                }
                exercits.get(0).soldatsFormacio(filesTerreny);
            }
            if (esmou2 == 0){
                if (exercits.get(1).calculaDireccio() == -1){
                    exercits.get(1).setPosicio(1200,10);
                }else{
                    exercits.get(1).setPosicio(10,1200);
                }
                exercits.get(1).soldatsFormacio(filesTerreny);
            }
        }
    }

}
