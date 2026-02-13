
package labahorcado;

import java.util.ArrayList;
import java.util.Random;


public class AdminPalabrasSecretas {

    private ArrayList<String> palabras;
    
    public AdminPalabrasSecretas(){
        palabras = new ArrayList<>();
    }
    
    private void agregarPalabra(String palabra) throws IllegalArgumentException {
    
        if(palabra == null || palabra.trim().isEmpty()){
            throw new IllegalArgumentException("Las palabras no pueden estar vacias");
        }
    
        palabra = palabra.toUpperCase();
        
        if(palabras.contains(palabra)){
            throw new IllegalArgumentException ("La palabra ya existe en la lista");
        }
        
        palabras.add(palabra);
        
    }
    
    public String obtenerPalabraAleatorio() throws IllegalArgumentException{
        
        if(palabras.isEmpty()){
            throw new IllegalArgumentException("No hay palabras disponibles");
            
        }
        
        Random random = new Random();
        int indice = random.nextInt(palabras.size());
        
        return palabras.get(indice);
    }
    
}
