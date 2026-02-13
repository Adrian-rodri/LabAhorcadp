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


public abstract class JuegoAhorcadoAzar extends JuegoAhorcadoBase{
    
   private String[] palabras = {"java", "programa", "computadora", "teclado", "pantalla"};
   private int intentosFallidos; 
   
   
   public JuegoAhorcadoAzar(){
       
       intentosFallidos= 0;
       letrasUsadas = new ArrayList<>();
       seleccionarPalabraAleatoria();
       
   }
   private void seleccionarPalabraAleatoria(){
       Random rand = new Random(); 
       int indice = rand.nextInt(palabras.length); 
       palabraSecreta = palabras[indice]; 
   }
   
   public void ingresarLetra(char letra){
       if(!letrasUsadas.contains(letra)){
           letrasUsadas.add(letra); 
           
           if(palabraSecreta.indexOf(letra) == -1 ){
               intentosFallidos++; 
           }
       }
   }
   public void mostrarProgreso(){
       for(int i = 0; i < palabraSecreta.length(); i++){
           char c = palabraSecreta.charAt(i);
           if(letrasUsadas.contains(c)){
               System.out.print(c + " ");
               
           }else{
               System.out.print("_ ");
           }
       }
       System.out.println(); 
   System.out.println("Intentos fallidos: " + intentosFallidos + "/" + limiteIntentos);
   }
   
}
