/**
 *
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


    ArrayList <Soldat> soldats = new ArrayList <Soldat>();
    /**
     * Nom de l'exercit.
     */
    private String nom;
    private int PosicioInicial;
    private int PosicioFinal;
    private int AMPLADAFILA = 80;
    private int ALTURAFILA = 100;
    //private int filesExercit;
    private Random rnd;
    public int esmouen;

    public Exercit(final String nombre) {
        nom = nombre;
        rnd = new Random();
    }

    public final void allistarSoldat(final Soldat soldat) {
        if (soldat != null) {
            soldats.add(soldat);
        }
    }
    public final void setPosicio(final int posicioi,
            final int posiciof) {
        PosicioInicial = posicioi;
        PosicioFinal = posiciof;
        //soldatsDefinirDestiX();
    }

    public final void soldatsFormacio(final int files){
        //filesExercit = files;
        int[] posicioEnLesFiles = new int[files];
        int puntBase = 0;

        int direccio = calculaDireccio();
        if (direccio < 0) {
            puntBase = 1200 - AMPLADAFILA;
        }
        for (Soldat s: soldats) {
            int fila = rnd.nextInt(files);
            s.posiciona(puntBase
                    + direccio * posicioEnLesFiles[fila] * AMPLADAFILA,
                    fila * ALTURAFILA);
            posicioEnLesFiles[fila]++;
        }
    }
    public final List<Soldat> getSoldats() {
        return soldats;
    }
    public final int calculaDireccio() {

        if (PosicioInicial - PosicioFinal == 0) {
            return 0;
        }
        return (PosicioInicial - PosicioFinal)
                    / Math.abs(PosicioFinal - PosicioInicial);
        //Retorna 1 o -1, -1 el té l'exercit de la DRETA.
    }
    public final int getNumeroDeSoldats() {
        return soldats.size();
    }
    //public final void setFilesExercit(final int files) {
    //    this.filesExercit = files;
    //}
    public final int moure(){
        esmouen = 0;
        for (int i = 0; i < soldats.size(); i++){
            esmouen += soldats.get(i).moure(calculaDireccio());
        }
        return esmouen;
    }
    public final int getEsMouen(){
        return esmouen;
    }
    public final void atacar(Exercit ex1){
        for (int i = 0; i < this.soldats.size(); i++){
            for (int j = 0; j < ex1.soldats.size(); j++){

                GRectangle soldat = soldats.get(i).getBounds();
                GRectangle enemic = ex1.soldats.get(j).getBounds();

                if (soldat.intersects(enemic)){
                    //ex1.soldats.remove(j);
                    GImage imatge = ex1.soldats.get(j).getGImage();
                    imatge.getParent().remove(imatge);
                    ex1.soldats.remove(j);
                }
            }
        }
    }
    public final String getNom(){
        return nom;
    }
}
