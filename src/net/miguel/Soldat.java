/**
 *.
 */
package net.miguel;

import java.util.Random;

import acm.graphics.GImage;
import acm.graphics.GRectangle;

/**
 * @author mikel
 *
 */
public class Soldat {

    /**
     * GImage de soldat.
     */
    private GImage imatge;
    /**
     * velocitat del soldat.
     */
    private static final int VELOCITAT = 10;
    /**
     * Random.
     */
    private Random rnd;
    /**
     * pantalla.
     */
    private Principal pantalla;
    /**
     *
     * @param im imatge del soldat.
     */
    public Soldat(final String im) {
        imatge = new GImage(im);
        rnd = new Random();
    }
    /**
     *
     * @return imatge de soldat.
     */
    public final GImage getGImage() {
        return imatge;
    }
    /**
     *
     * @param i posicio inicial.
     * @param j posicio final.
     */
    public final void posiciona(final int i, final int j) {
        imatge.setLocation(i, j);
    }
    /**
     *
     * @param direccio a moure el soldat.
     * @return si es mou o no.
     */
    public final int moure(final int direccio) {
        if (direccio == 1 && (imatge.getX() + VELOCITAT + imatge.getWidth())
                > pantalla.getAmplada() || direccio == -1 && (imatge.getX()
                        - VELOCITAT) < pantalla.getPosInicial()) {
            if (direccio == 1) {
                imatge.setLocation(pantalla.getAmplada()
                        - imatge.getWidth(), imatge.getY());
            } else {
                imatge.setLocation(pantalla.getPosInicial(), imatge.getY());
            }
            return 0;
        } else {
            imatge.setLocation(direccio * rnd.nextInt(VELOCITAT)
                    + imatge.getX(), imatge.getY());
            return 1;
        }
    }
    /**
     *
     * @return el cuadrat que ocupa.
     */
    public final GRectangle getBounds() {
        return imatge.getBounds();
    }
}
