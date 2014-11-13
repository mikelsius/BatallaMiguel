/**
 *.
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
    /**
     * posicio inicial.
     */
    private static final int POSICIOINICIAL = 10;
    /**
     * Amplada de la pantalla.
     */
    private static final int AMPLADAPANTALLA = 1200;
    /**
     * Alçada de la pantalla.
     */
    private static final int ALÇADAPANTALLA = 600;
    /**
     * comença el programa.
     */
    public final void run() {
        setSize(AMPLADAPANTALLA, ALÇADAPANTALLA);

        CampDeBatalla campBatalla = new CampDeBatalla(this);

        Exercit exercit = creaExercit("Kennys", NUMSOLDATS, "SoldatKenny.png");
        campBatalla.afegirExercit(exercit, POSICIOINICIAL, getWidth());

        exercit = creaExercit("Cartmans", NUMSOLDATS, "SoldatCartman.jpg");
        campBatalla.afegirExercit(exercit, getWidth(), POSICIOINICIAL);

        campBatalla.batalla();


    }
    /**
     *
     * @param nom del exercit
     * @param numSoldats numero de soldats
     * @param imatge imatge dels soldats
     * @return exercit senser.
     */
    public final Exercit creaExercit(final String nom,
            final int numSoldats, final String imatge) {

        Exercit x = new Exercit(nom);

        for (int i = 0; i < numSoldats; i++) {
            Soldat soldadet = new Soldat(imatge);
            x.allistarSoldat(soldadet);
        }
        return x;
    }
    /**
     *
     * @return amplada.
     */
    public final int getAmplada() {
        return AMPLADAPANTALLA;
    }
    /**
     *
     * @return posicio inicial.
     */
    public final int getPosInicial() {
        return POSICIOINICIAL;
    }
}
