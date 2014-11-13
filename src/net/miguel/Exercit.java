/**
 *.
 */
package net.miguel;
import java.util.ArrayList;

import java.util.List;
import java.util.Random;

import acm.graphics.GImage;
import acm.graphics.GRectangle;


/**
 * @author mikel
 *
 */
public class Exercit {
    /**
     * Arraylist de soldats.
     */
    private ArrayList <Soldat> soldats = new ArrayList <Soldat>();
    /**
     * Nom de l'exercit.
     */
    private String nom;
    /**
     * posicio inicial.
     */
    private int posicioInicial;
    /**
     *  posicio final.
     */
    private int posicioFinal;
    /**
     * amplada entre soldats en cada fila.
     */
    private static final int AMPLADAFILA = 60;
    /**
     * altura per fila.
     */
    private static final int ALTURAFILA = 100;
    //private int filesExercit;
    /**
     * Random.
     */
    private Random rnd;
    /**
     * num de quants es mouen.
     */
    private int esmouen;
    /**
     *
     * @param nombre del exercit.
     */
    public Exercit(final String nombre) {
        nom = nombre;
        rnd = new Random();
    }
    /**
     *
     * @param soldat per allistar.
     */
    public final void allistarSoldat(final Soldat soldat) {
        if (soldat != null) {
            soldats.add(soldat);
        }
    }
    /**
     *
     * @param posicioi posicio inicial
     * @param posiciof posicio final
     */
    public final void setPosicio(final int posicioi,
            final int posiciof) {
        posicioInicial = posicioi;
        posicioFinal = posiciof;
    }
    /**
     *
     * @param files que tindra la formacio.
     */
    public final void soldatsFormacio(final int files) {
        //filesExercit = files;
        int[] posicioEnLesFiles = new int[files];
        int puntBase = 0;

        int direccio = calculaDireccio();
        if (direccio < 0) {
            puntBase = posicioFinal - AMPLADAFILA;
        }
        for (Soldat s: soldats) {
            int fila = rnd.nextInt(files);
            s.posiciona(puntBase
                    + direccio * posicioEnLesFiles[fila] * AMPLADAFILA,
                    fila * ALTURAFILA);
            //s.setDestix(puntBase);
            posicioEnLesFiles[fila]++;
        }
    }
    /**
     *
     * @return llista de soldats.
     */
    public final List<Soldat> getSoldats() {
        return soldats;
    }
    /**
     *
     * @return direccio del exercit
     */
    public final int calculaDireccio() {

        if (posicioInicial - posicioFinal == 0) {
            return 0;
        }
        return (posicioInicial - posicioFinal)
                    / Math.abs(posicioFinal - posicioInicial);
        //Retorna 1 o -1, -1 el té l'exercit de la DRETA.
    }
    /**
     * calculem el desti de soldat.
     */
    public final int calculaDesti(){
        int direccio = calculaDireccio();
        if (direccio == 1) {
            return 1200;
        } else {
            return 0;
        }

    }
    /**
     *
     * @return soldats vius.
     */
    public final int getNumeroDeSoldats() {
        return soldats.size();
    }
    /**
     *
     * @return total de soldats que es mouen.
     */
    public final int moure() {
        esmouen = 0;
        for (int i = 0; i < soldats.size(); i++) {
            esmouen += soldats.get(i).moure(calculaDesti(), calculaDireccio());
        }
        return esmouen;
    }
    /**
     *
     * @return retorna total de soldats que s'han mogut.
     */
    public final int getEsMouen() {
        return esmouen;
    }
    /**
     *
     * @param ex1 exercit enemic.
     */
    public final void atacar(final Exercit ex1) {
        for (int i = 0; i < this.soldats.size(); i++) {
            for (int j = 0; j < ex1.soldats.size(); j++) {

                GRectangle soldat = soldats.get(i).getBounds();
                GRectangle enemic = ex1.soldats.get(j).getBounds();

                if (soldat.intersects(enemic)) {
                    //ex1.soldats.remove(j);
                    GImage imatge = ex1.soldats.get(j).getGImage();
                    imatge.getParent().remove(imatge);
                    ex1.soldats.remove(j);
                }
            }
        }
    }
    /**
     *
     * @return nom del exercit.
     */
    public final String getNom() {
        return nom;
    }
}
