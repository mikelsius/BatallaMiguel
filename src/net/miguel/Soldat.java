/**
 *
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
    private static final int VELOCITAT= 10;
    private Random rnd;
    /**
     * Constructor.
     */
    public Soldat(String im) {
        imatge = new GImage(im);
        rnd = new Random();
    }
    /**
     *
     * @return imatge de soldat.
     */
    public GImage getGImage(){
        return imatge;
    }
    public void posiciona(int i, int j) {
        imatge.setLocation(i,j);
    }
    public int moure(int direccio){
        if (direccio == 1 && (imatge.getX() + VELOCITAT) > 1150 || direccio == -1 && (imatge.getX() - VELOCITAT) < 10){
            if (direccio ==1){
                imatge.setLocation(1150,imatge.getY());
            }else{
                imatge.setLocation(10,imatge.getY());
            }
            return 0;
        }else{
            imatge.setLocation(direccio * rnd.nextInt(VELOCITAT) + imatge.getX(),imatge.getY());
            return 1;
        }
    }
    public final GRectangle getBounds() {
        return imatge.getBounds();
    }
}
