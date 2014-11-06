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
    private static final int NUMSOLDATS = 15;
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







/**
ArrayList <Soldat> soldats = new ArrayList <Soldat>(); //EL array de soldats.
for (int i = 0; i < 10; i++) {
    Soldat x = new Soldat("SoldatKenny.png");

    x.posiciona(100 * i, 400);
    //add(Soldat);
    soldats.add(x);
}
for (int i = 0; i < soldats.size(); i++){
    add(soldats.get(i).getGImage());
}
Random rnd = new Random();
**/
/**while (soldado1.getX() < getWidth() - 100 || soldado2.getX() > 100) {
    int numRandom = rnd.nextInt(30);
    soldado1.setLocation(numRandom + soldado1.getX(), 100);
    if (soldado1.getX() + soldado1.getWidth() > soldado2.getX()
            && soldado1.getX() + soldado1.getWidth() < soldado2.getX()
                    + soldado2.getWidth() && soldado1 != null) {
        // eliminem soldado2.
        soldado2.getParent().remove(soldado2);
        soldado2 = null;
    }
    pause(100);
    soldado2.setLocation(soldado2.getX() - numRandom, 100);
    if (soldado2.getX() < soldado1.getX() + soldado1.getWidth()
            && soldado2.getX() > soldado1.getX() && soldado2!= null) {
        // eliminem soldado1.
        soldado1.getParent().remove(soldado1);
        soldado1 = null;
    }
    pause(100);
}


for (int i = 0; i < getWidth() - soldado.getWidth(); i++) {
soldado.setLocation(i, 100);
pause(5);
}
**/
