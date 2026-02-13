/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labahorcado;

import java.util.ArrayList;
import java.util.Random;

public class JuegoAhorcadoAzar extends JuegoAhorcadoBase {

    private String[] palabras = {"java", "programa", "computadora", "teclado", "pantalla"};
    private int intentosFallidos;

    public JuegoAhorcadoAzar() {
        intentosFallidos = 0;
        letrasUsadas = new ArrayList<>();
        inicializarPalabraSecreta();
    }

    private void seleccionarPalabraAleatoria() {
        Random rand = new Random();
        int indice = rand.nextInt(palabras.length);
        palabraSecreta = palabras[indice];
    }

    @Override
    public void inicializarPalabraSecreta() {
        seleccionarPalabraAleatoria();
        palabraActual = "";

        for (int i = 0; i < palabraSecreta.length(); i++) {
            palabraActual += "_";
        }
    }

    public void ingresarLetra(char letra) {
        if (!letrasUsadas.contains(letra)) {
            letrasUsadas.add(letra);

            if (!verificarLetra(letra)) {
                intentosFallidos++;
            } else {
                actualizarPalabraActual(letra);
            }
        }
    }

    @Override
    protected boolean verificarLetra(char letra) {
        return palabraSecreta.indexOf(letra) != -1;
    }

    @Override
    protected void actualizarPalabraActual(char letra) {
        String nueva = "";

        for (int i = 0; i < palabraSecreta.length(); i++) {
            if (palabraSecreta.charAt(i) == letra) {
                nueva += letra;
            } else {
                nueva += palabraActual.charAt(i);
            }
        }

        palabraActual = nueva;
    }

    @Override
    protected boolean hasGanado() {
        return palabraActual.equals(palabraSecreta);
    }

    public void mostrarProgreso() {
        for (int i = 0; i < palabraActual.length(); i++) {
            System.out.print(palabraActual.charAt(i) + " ");
        }
        System.out.println();
        System.out.println("Intentos fallidos: " + intentosFallidos + "/" + limiteIntentos);
    }

    @Override
    public void jugar() {
        
}
}
