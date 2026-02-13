/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labahorcado;

/**
 *
 * @author spodi
 */




import java.util.ArrayList;
import java.util.Random;



public class AdminPalabrasSecretas {



    private ArrayList<String> palabras;
    
    public AdminPalabrasSecretas(){
        palabras = new ArrayList<>();
    }

    public void agregrarPlabras(String palabra){
        if(!palabras.contains(palabra)){
            palabras.add(palabra); 
        }else{
            System.out.println("La palabra ya existe en la lista"); 
            
        }
    }
        public String obtenerPalabraAleatoria() {
        if (palabras.isEmpty()) {
            return null;
        }

        Random rand = new Random();
        int indice = rand.nextInt(palabras.size());
        return palabras.get(indice);
    }

            public void mostrarPalabras() {
        for (String palabra : palabras) {
            System.out.println(palabra);
        }
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
    
    public ArrayList<String> getPalabras(){
        return palabras;
    }
    

}
