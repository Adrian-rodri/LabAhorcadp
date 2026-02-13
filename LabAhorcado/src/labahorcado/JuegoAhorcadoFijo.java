/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labahorcado;

/**
 *
 * @author gpopo
 */
public class JuegoAhorcadoFijo extends JuegoAhorcadoBase {
    private String palabraSecreta;
    private int intentosRestantes;
    
    public JuegoAhorcadoFijo(String palabra){
        this.palabraSecreta = palabra.toUpperCase();
        this.intentosRestantes = 6;
    }
    
    public boolean intentarLetra(char letra) {  
        letra = Character.toUpperCase(letra);
        
        if(letrasIntentadas.contains(letra)) {
            return false;
        }
        
        letrasIntentadas.add(letra);
        if(palabraSecreta.contains(String.valueOf(letra))){
            return true;
        }else {
            intentosRestantes--;
            return false;
        }
    
    }
    
}
