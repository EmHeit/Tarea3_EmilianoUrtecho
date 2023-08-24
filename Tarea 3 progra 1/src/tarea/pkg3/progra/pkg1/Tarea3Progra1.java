/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tarea.pkg3.progra.pkg1;

import java.util.Scanner;

/**
 *
 * @author emili
 */
public class Tarea3Progra1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner escan = new Scanner (System.in);
        
        System.out.println("        ~MENU~");
        System.out.println("    1. Veamos si podemos formar la palabra");
        System.out.println("    2. Números primero.");
        System.out.println("    3. Ordenar alfabéticamente");
        System.out.println("    4. Codificar cadenas.");
        System.out.println("    5. Jugando con arreglos.");
        System.out.println("    6. SALIR");
        System.out.print("Que desea ver?: ");
        int eleccion = escan.nextInt();
        
        do {
            switch (eleccion){
                case 1://Veamos si podemos formar la palabra
                    
                    System.out.print("Ingrese una cadena: ");
                    String cadena1 = escan.nextLine();
                    cadena1 = escan.nextLine();
                    System.out.print("Ingrese una segunda cadena: ");
                    String cadena2 = escan.nextLine();
                    
                    if (cadena1.length() > cadena2.length()) {
                        String formar = cadena1;
                        cadena1 = cadena2;
                        cadena2 = formar;
                    }
                    if (formarPalabra(cadena1, cadena2)) {
                        System.out.println("Si se puede armar la palabra "+cadena1);
                    }else{
                        System.out.println("No se puede armar la palabra "+cadena1);
                    }
                    break;
                
                case 2://Números primero.
                    
                    System.out.print("Ingrese su cadena: ");
                    String cadena3 = escan.next();
                    
                    String output=palabrasNumeros(cadena3);
                    System.out.println("Output: "+output);
                    
                    break;
                
                case 3: //Ordenar alfabéticamente
                    System.out.print("Input: ");
                    String cadena4 = escan.nextLine();
                    cadena4 = escan.nextLine();
                    
                    int conteonumeros = alfabeticamente(cadena4);
                    System.out.println("Conteo de numeros: "+conteonumeros);
                    //La cadena me sale alfabeticamente pero al reves
                    //No supe como resolverlo :(
                    break;
                
                case 4://Codificar cadenas.
                    
                    
                    break;
                
                case 5://Jugando con arreglos.
                    
                    int[] num = new int[10];
                    
                    rellenarValores(num);
                    imprimirValores(num);
                    
                    break;
                
                case 6:
                    System.out.println("Si quiere salirse no mas empezar entonces vuelva a presioanr la tecla 6.");
                    break;
                
                default:
                    System.out.println("Lo siento, no puedo leer eso. Pruebe con otra telca, mas especificamente una de las siguentes opciones");
                    break;
            }
        
        System.out.println("        ~MENU~");
        System.out.println("    1. Veamos si podemos formar la palabra");
        System.out.println("    2. Números primero.");
        System.out.println("    3. Ordenar alfabéticamente");
        System.out.println("    4. Codificar cadenas.");
        System.out.println("    5. Jugando con arreglos.");
        System.out.println("    6. SALIR");
        System.out.print("Que desea ver?: ");
        eleccion = escan.nextInt();
            
        } while (eleccion != 6);
        
    }
    
    public static boolean formarPalabra (String palabra1, String palabra2){
        int [] contador = new int[128];
        char caracter;
        for (int i = 0; i < palabra2.length(); i++) {
            caracter = palabra2.charAt(i);
            contador[caracter]++;
        }
        for (int i = 0; i < palabra1.length(); i++) {
            caracter = palabra2.charAt(i);
            if (contador[caracter] == 0) {
                return false;
            }
            contador[caracter]--;
        }
        return true;
    }
    
    public static String palabrasNumeros (String completo){
        String numeros = "";
        String caracteres = "";
        char caracter;
        for (int i = 0; i < completo.length(); i++) {
            caracter = completo.charAt(i);
            if (Character.isDigit(caracter)) {
                numeros+=caracter;
            }else if (Character.isLetter(caracter)) {
                caracteres+=caracter;
            }
        }
        return numeros + caracteres;
    }
    
    public static int alfabeticamente (String orden){
        orden = orden.toLowerCase();
        char[]caracter = orden.toCharArray();
        
        for (int i = 0; i < caracter.length-1; i++) {
            for (int j = 1; j < caracter.length; j++) {
                if (caracter[i]>caracter[j]) {
                    char formar1 = caracter[j];
                    caracter[j] = caracter[i];
                    caracter[i]=formar1;
                }
            }
        }
        int conteoNumeros = contarNumeros(caracter);
        System.out.println("Output: "+new String(caracter)); //Si no hago esto no me orden ael string alfabeticamente
        return conteoNumeros;
    }
    
    public static int contarNumeros (char[] caracters){
        int conteoNumeros = 0;
        char caracter;
        for (int i = 0; i < caracters.length; i++) {
            caracter = caracters[i];
            if (caracter >='0' && caracter <= '9') {
                conteoNumeros++;
            }
        }
        return conteoNumeros;
    }
    
    public static void rellenarValores (int[]array){
        Scanner escan = new Scanner(System.in);
        System.out.print("Ingrese 10 valores para el array: ");
        for (int i = 0; i < array.length; i++) {
            System.out.println("- ");
            array[i]=escan.nextInt();
        }
    }
    
    public static void imprimirValores (int[]arrays){
        System.out.println("El arreglo es: ");
        for (int i = 0; i < arrays.length; i++) {
            System.out.println("La posicion "+i+" es "+arrays[i]);
        }
    }
    
}
