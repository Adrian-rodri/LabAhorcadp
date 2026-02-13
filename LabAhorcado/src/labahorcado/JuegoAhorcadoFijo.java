/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labahorcado;
import java.util.ArrayList;
/**
 *
 * @author gpopo
 */
public class JuegoAhorcadoFijo extends JuegoAhorcadoBase {
    private ArrayList<Character> letrasIncorrectas;
    
    public JuegoAhorcadoFijo(String palabraSecreta) {
        super();
        
        this.palabraSecreta = palabraSecreta.toUpperCase();
        this.intentos = limiteIntentos;
        this.letrasIncorrectas = new ArrayList<>();
        
        String temp = "";
        for(int i = 0; i<palabraSecreta.length(); i++) {
            temp += "_";
        }
        this.palabraActual = temp;
    }
    
    public boolean intentarLetra(char letra) {
        letra = Character.toUpperCase(letra);
        
        if(letraYaIntentada(letra)){
            return false;      
        }
        
        letrasUsadas.add(letra);
        boolean esCorrecto = verificarLetra(letra);
        
        if(esCorrecto){
            actualizarPalabraActual(letra);
    }else{
            intentos--;
            letrasIncorrectas.add(letra);
        }
        return esCorrecto;
    }
    
    @Override
    protected void actualizarPalabraActual(char letra){
        char[] palabraArray = palabraActual.toCharArray();
        for(int i = 0; i < palabraSecreta.length(); i++) {
            if(palabraSecreta.charAt(i) == letra){
                palabraArray[i] = letra;
            }
        }
        palabraActual = new String(palabraArray);
    }
    
    @Override
    protected boolean verificarLetra(char letra){
        for(int i = 0; i < palabraSecreta.length(); i++){
            if(palabraSecreta.charAt(i) == letra){
                return true;
            }
        }
        return false;
    }
    
    
    @Override
    protected boolean hasGanado(){
        return palabraActual.equals(palabraSecreta);
    }
    
    public boolean hasPerdido(){
        return intentos == 0;
    }
    
    
    
    public boolean letraYaIntentada(char letra){
        letra = Character.toUpperCase(letra);
        
        for(int i = 0; i < letrasUsadas.size(); i++) {
            if(letrasUsadas.get(i) == letra){
                return true;
            }
        }
        return false;
    }
    
    public String getPalabraSecreta(){ 
        return palabraSecreta;
    }
    
    public String getPalabraActual(){
        return palabraActual;
    }
    
    int getIntentosRestantes(){
        return intentos;
    }
    
    public ArrayList<Character> getLetrasIncorrectas() {
        return letrasIncorrectas;
    }
    
    public ArrayList<Character> getLetrasUsadas() {
        return letrasUsadas;
    }
    
    public String getFiguraActual(){
        int errores = limiteIntentos - intentos;
        
        if(errores >= 0 && errores < figuraAhorcado.size()){
            return figuraAhorcado.get(errores);
        }
        return figuraAhorcado.get(figuraAhorcado.size()-1);
    }
    
    public boolean juegoTerminado(){
        return hasGanado() || hasPerdido();
    }

    @Override
    public void inicializarPalabraSecreta() {
        
        String temp = "_";
        for(int i = 0; i <palabraSecreta.length(); i++){
            temp += "_";
        }
        this.palabraActual = temp;
        this.intentos = limiteIntentos;
        this.letrasUsadas.clear();
        this.letrasIncorrectas.clear();
    }

    @Override
    public void jugar() {
    }
    
    public void reiniciar() {
        inicializarPalabraSecreta();
    }
    
}    
