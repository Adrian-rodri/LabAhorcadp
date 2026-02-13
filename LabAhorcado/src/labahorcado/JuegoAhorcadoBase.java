
package labahorcado;
 
import java.util.ArrayList;

public abstract class JuegoAhorcadoBase implements juegoAhorcado {
    
    protected String palabraSecreta;
    protected String palabraActual;
    protected int intentos;
    protected final int limiteIntentos = 6;
    protected ArrayList<Character> letrasUsadas;
    protected ArrayList<String> figuraAhorcado;
   
    public JuegoAhorcadoBase(){
        this.intentos=limiteIntentos;
        this.letrasUsadas= new ArrayList();
        this.figuraAhorcado=new ArrayList();
        inicializarFigura(); 
    }
    
    private void inicializarFigura(){
        
        
        figuraAhorcado.add(
                           " +-----\n"+
                           "      |\n"+
                           "      |\n"+
                           "      |\n"+
                           "      |\n"+
                           "      |\n"+
                           "======|\n");
        
        figuraAhorcado.add(
                           " +-----\n"+
                           " |     |\n"+
                           " O     |\n"+
                           "      |\n"+
                           "      |\n"+
                           "      |\n"+
                           "======|\n");      

        figuraAhorcado.add(
                            " +---- \n" +
                            " |    |\n" +
                            " O    |\n" +
                            " |    |\n" +
                            "      |\n" +
                            "      |\n" +
                            "======="
                        );

                        figuraAhorcado.add(
                            " +---- \n" +
                            " |    |\n" +
                            " O    |\n" +
                            "/|    |\n" +
                            "      |\n" +
                            "      |\n" +
                            "======="
                        );

                        figuraAhorcado.add(
                            " +---- \n" +
                            " |     |\n" +
                            " O     |\n" +
                            "/|\\   |\n" +
                            "       |\n" +
                            "       |\n" +
                            "======="
                        );

                        figuraAhorcado.add(
                            " +---- \n" +
                            " |     |\n" +
                            " O     |\n" +
                            "/|\\   |\n" +
                            "/      |\n" +
                            "       |\n" +
                            "======="
                        );

                        figuraAhorcado.add(
                            " +---- \n" +
                            " |     |\n" +
                            " O     |\n" +
                            "/|\\   |\n" +
                            "/ \\   |\n" +
                            "       |\n" +
                            "======="
                        );        
     
    }
    protected abstract void actualizarPalabraActual(char letra);
    protected abstract boolean verificarLetra(char letra);
    protected abstract boolean hasGanado();
}
