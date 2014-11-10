/**
 *
 */
package net.miguel;

import acm.program.GraphicsProgram;

/**
 * @author mikel
 *
 */
public class Principal extends GraphicsProgram {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    /**
     * num soldats de cada exercit.
     */
    private static final int NUMSOLDATS = 25;
    private static final int POSICIOINICIAL = 10;
    /**
     *
     */
    public void run() {
        setSize(1200, 600);

        CampDeBatalla campBatalla = new CampDeBatalla(this);

        Exercit exercit = creaExercit("Kennys", NUMSOLDATS,"SoldatKenny.png");
        campBatalla.afegirExercit(exercit, POSICIOINICIAL, getWidth());

        exercit = creaExercit("Cartmans", NUMSOLDATS,"SoldatCartman.jpg");
        campBatalla.afegirExercit(exercit,getWidth(),POSICIOINICIAL);

        campBatalla.batalla();


    }
    public final Exercit creaExercit(final String nom,
            final int numSoldats, final String imatge) {

        Exercit x = new Exercit(nom);

        for (int i = 0; i < numSoldats; i++) {
            Soldat soldadet = new Soldat(imatge);
            x.allistarSoldat(soldadet);
        }
        return x;
    }
}
