/**
 *
 */
package net.miguel;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


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
    private int AMPLADAFILA = 100;
    private int ALTURAFILA = 100;
    private int filesExercit;
    private Random rnd;

    public Exercit(final String nombre) {
        nom = nombre;
    }
    
    public final void crearExercits() {
    }
    public final void colocarSoldats() {
    }
    
    public final void allistarSoldat(final Soldat soldat) {
        if (soldat != null) {
            soldats.add(soldat);
        }
    }
    public final void setPosicio(final int posicioi, final int posiciof){
    	
    }
    public final void soldatsFormacioInicial(final int files){
    	filesExercit = files;
        int[] posicioEnLesFiles = new int[files];
        int puntBase = 0;

        //int direccio = calculaDireccio();
        int direccio = 1;
        //if (direccio < 0) {
        //    puntBase = midaCampBatalla - AMPLADAFILA;
        //}
        for (Soldat s: soldats) {
            //int fila = Aleatori.obtenir(files);
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
}
