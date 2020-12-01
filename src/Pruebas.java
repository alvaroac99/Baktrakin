import java.util.*;
import java.lang.*;

public class Pruebas {


    private static int[] vector={11,7,13};
    private static int num;
    private static int[] sol;
    private static int nivel;
    private static Booleano exito;


    public static void main(String[] args){
        System.out.println("***********************************************************");
        System.out.println("*****************EJERCICIOS DE BACKTRACKING****************");
        System.out.println("***********************************************************");
        System.out.println("PRUEBA SUMA SUBCONJUNTOS CON ARBOL DE BUSQUEDA BINARIO");
        Ejercicios.SumaSubconjuntos(vector,20,sol,3,exito);
        for(int i=0;i<sol.length;i++)
            System.out.println(sol[i]);
    }

}


