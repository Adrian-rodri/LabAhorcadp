
package labahorcado;
 
import java.util.ArrayList;

public abstract class JuegoAhorcadoBase implements juegoAhorcado {
    
    protected String palabraSecreta;
    protected String palabraActual;
    protected int intentos;
    protected int limiteIntentos = 6;
    protected ArrayList<Character> letrasUsadas;
    protected ArrayList<String> figuraAhorcado;
   
    public JuegoAhorcadoBase(){
        this.intentos=limiteIntentos;
        this.letrasUsadas= new ArrayList();
        this.figuraAhorcado=new ArrayList();
        
    }
    
    private void inicializarFigura(){
        
    }
    protected abstract void actualizarPalabraActual(char letra);
    protected abstract boolean verificarLetra(char letra);
    protected abstract boolean hasGanado();
}
