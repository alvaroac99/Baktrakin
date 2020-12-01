import java.util.*;
import java.lang.*;

public class Pruebas {


    private static int[] vector={11,7,13};
    private static int num = 20;
    private static int[] sol = new int[vector.length];
    private static int suma = 0;
    private static int nivel;
    private static Boolean exito=false;


    public static void main(String[] args){
        System.out.println("***********************************************************");
        System.out.println("*****************EJERCICIOS DE BACKTRACKING****************");
        System.out.println("***********************************************************");
        //System.out.println("PRUEBA SUMA SUBCONJUNTOS CON ARBOL DE BUSQUEDA BINARIO");        //NO FUNCIONA
        //Ejercicios.SumaSubconjuntos(vector,20,sol,0,exito);
        System.out.println("PRUEBA SUMA SUBCONJUNTOS CON ARBOL DE BUSQUEDA BINARIO V2");
        for (int i=0; i<sol.length; i++) sol[i]=0;
        Ejercicios.subconjuntoSumaBack2(vector, num, sol, 0, suma, exito);
        for (int j=0; j<sol.length; j++) System.out.println(sol[j]);
        for ( int j=0; j<sol.length; j++) System.out.println(vector[j]);
        System.out.println(nivel+" "+suma+" "+exito );


        System.out.println("PROBLEMA DEL CABALLERO");
        int[][] tablero = new int[6][6];
        for (int i=0; i<tablero.length; i++)
            for (int j=0; j< tablero.length; j++)
                tablero[i][j]=0;
        tablero[0][0]=1;

        Ejercicios.Caballero(tablero, 2, 0, 0, exito);

        for (int i=0; i<tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }


        System.out.println("PROBLEMA DE LAS 8 REINAS");
        int[] damas = new int[4];
        Ejercicios.reinas(damas, 0, exito);
    }

}


