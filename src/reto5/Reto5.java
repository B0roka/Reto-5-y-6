/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reto5;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
/**
 *
 * @author aleks
 */
public class Reto5 {
    public static BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        // facil, intermedio, avanzado
        String facil[] = { "tina", "casa", "sala" };
        String intermedio[] = {"animales", "bolsillo", "cabalgar"};
        String avanzado[] = {"certificador", "adolescentes", "definiciones", "hamburguesas" };
        int opcion;
        int posicion_palabra;
        String palabra_buscada = "";
        String mascara = "";
        String letra_buscada;
        do{
            System.out.println("Indica el nivel del juego \n1.Facil \n2.Intermedio \n3.Avanzado \nO.salir");
            opcion = Integer.parseInt(entrada.readLine());
            while( opcion < 0 || opcion > 3){
                System.out.println("Favor de indicar un valor dentro de las opcion");
                System.out.println("Indica el nivel del juego \n1.Facil \n2.Intermedio \n3.Avanzado \nO.salir");
                opcion = Integer.parseInt(entrada.readLine());
            }
            
            if(opcion == 0){
                System.out.println("Gracias por usar el programa.");
                break;
            }
            
            switch(opcion){
                case 1:
                    posicion_palabra = (int) (Math.random() * facil.length+0);
                    palabra_buscada = facil[posicion_palabra];
                    mascara = "XXXX";
                    break;
                case 2:
                    posicion_palabra = (int) (Math.random() * intermedio.length+0); 
                    palabra_buscada = intermedio[posicion_palabra];
                    mascara = "********";
                    break;
                case 3:
                    posicion_palabra = (int) (Math.random() * avanzado.length+0);
                    palabra_buscada = avanzado[posicion_palabra];
                    mascara = "************";
                    break;
                default:
                    System.out.println("Opción no valida"); // nunca debería entrar
                    break;
            }
            
            System.out.println("Palabra buscada es " + palabra_buscada);
            
            do{
                System.out.println("Indica una letra");
                letra_buscada = entrada.readLine();
                int mostrar_no_coincidencia = 1;
                for(int p = 0; p < palabra_buscada.length(); p++){
                    if(letra_buscada.charAt(0) == palabra_buscada.charAt(p)){
                       String[] letras_mascara = mascara.split("");
                       letras_mascara[p] = letra_buscada;
                       mascara = String.join("", letras_mascara);
                       mostrar_no_coincidencia = 0;
                   }     
                }
                // c a s a --> 4   0...3 palabra_buscada.charAt(0)
                // X X X X
                // a
                if (mostrar_no_coincidencia == 1){
                    System.out.println("Intentalo de nuevo !!!");
                }
                System.out.println(mascara);
                
                if(palabra_buscada.equals(mascara)){
                    System.out.println("Felicidades has descubierto la palabra");
                    break;
                }
            }while(!letra_buscada.equals("0"));
            
            if(letra_buscada.equals("0")){
                System.out.println("Gracias por usar el programa.");
                break;
            }
            
            // Final del ciclo
            System.out.println("Usuario desea jugar de nuevo? 1. Si 0. No");
            opcion = Integer.parseInt(entrada.readLine());
        }while(opcion != 0);
    }
    
}