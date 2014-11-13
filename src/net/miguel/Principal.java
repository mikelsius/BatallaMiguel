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
        
        String[] LlistaSoldats1 = {"SoldatKenny.png","SoldatKennyAngel.jpg","SoldatKennyZombie.jpg","SoldatKennyGegant.png"};
        String[] LlistaSoldats2 = {"SoldatCartman.jpg","SoldatCartmanDimoni.jpg","SoldatCartmanZombie.jpg","SoldatCartmanGegant.jpg"};
        Exercit exercit = creaExercit("Kennys", NUMSOLDATS, LlistaSoldats1);
        campBatalla.afegirExercit(exercit, POSICIOINICIAL, getWidth());

        exercit = creaExercit("Cartmans", NUMSOLDATS, LlistaSoldats2);
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
            final int numSoldats, final String[] imatges) {

        Exercit x = new Exercit(nom);

        for (int i = 0; i < numSoldats; i++) {
            Soldat soldadet = new Soldat(imatges[0]);
            x.allistarSoldat(soldadet);
        }
        for (int i = 0; i < 2; i++){
        	Soldat soldatEspecial = new SoldatEspecial(imatges[1]);
        	x.allistarSoldat(soldatEspecial);
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
