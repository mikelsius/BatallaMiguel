/**
 *
 */
package net.miguel;

import java.awt.Canvas;
import java.util.ArrayList;
import java.util.Random;
import acm.graphics.GImage;
import acm.program.GraphicsProgram;

/**
 * @author mikel
 *
 */
public class Principal extends GraphicsProgram {

    /**
     *
     */
    public void run() {
        setSize(1200, 600);

        ArrayList<Soldat> soldats = new ArrayList<Soldat>(); //EL array de soldats.

        //GImage soldado1 = new GImage("Soldado.png");
        //GImage soldado2 = new GImage("Soldado1.png");
        //GImage soldado3 = new GImage("Soldado1.png");

        //add(soldado2,50 + soldado2.getWidth(), 100);
        //add(soldado3,soldado3.getWidth() + 350, 100);
        //add(soldado1);
        //add(soldado1, 100,0);

        for (int i = 0; i < 10; i++) {
            Soldat x = new Soldat("Soldado.png");

            x.posiciona(100 * i, 400);
            //add(Soldat);
            soldats.add(x);
        }
        for (int i = 0; i < soldats.size(); i++){
            add(soldats.get(i).getGImage());
        }



        //soldado1.setLocation(50 + soldado1.getWidth(), 100);
        //soldado2.setLocation(getWidth() - soldado2.getWidth() - 50, 100);

        Random rnd = new Random();

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
        **/

        // for (int i = 0; i < getWidth() - soldado.getWidth(); i++) {
        // soldado.setLocation(i, 100);
        // pause(5);
        // }
    }
}
