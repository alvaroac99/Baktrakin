import java.util.*;
import java.lang.*;

public class Pruebas {


    private static int[] vector={11,7,13};
    private static int num;
    private static int[] sol={20};
    private static int nivel;
    private static Boolean exito=false;


    public static void main(String[] args){
        System.out.println("***********************************************************");
        System.out.println("*****************EJERCICIOS DE BACKTRACKING****************");
        System.out.println("***********************************************************");
        System.out.println("PRUEBA SUMA SUBCONJUNTOS CON ARBOL DE BUSQUEDA BINARIO");
        Ejercicios.SumaSubconjuntos(vector,20,sol,0,exito);

        for (int j=0;j<vector.length;j++)
            System.out.println(vector[j]);
    }

}


