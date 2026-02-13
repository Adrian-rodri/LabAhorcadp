
package labahorcado;

import java.util.ArrayList;


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
}
