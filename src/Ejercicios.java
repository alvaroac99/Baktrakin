public class Ejercicios {

    /*ESQUEMA GENERAL

    * void vueltaAtras (Estado estado, Booleano exito, …){
            if (esSolucion(estado)) {
                exito.setValor(true);
            } else {
                   inicializar_conjunto_de_candidatos();
                   while ((!exito.getValor()) && (hay_mas_candidatos())){
                        seleccionar_un_candidato();
                        if (aceptable(candidato)){
                             proximoEstado = anotar_candidato();
                             vueltaAtras(proximoEstado, exito, ...);
                             if (!exito.getValor()) {
                                desanotar_candidato();
                               }
                        }if aceptable
                    } while
            } else
    */

    public static int suma(int[] solucion, int[] vector, int nivel) {
        int suma = 0;
        for (int i = 0; i < nivel; i++)
            if (solucion[i] == 1) suma = suma + vector[i];
        return suma;
    }

    //arbol de busqueda binario
    public static void SumaSubconjuntos(int[] vector, int num, int[] sol, int nivel, Boolean exito) {
        if (nivel == vector.length) {
            if (suma(sol, vector, nivel) == num) exito = true;
        } else {
            int c = 0; //candidatos, si 0 no añadir 1 añadir
            while (!exito && (c < 2)) {
                if (c == 0 || suma(sol, vector, nivel) + vector[nivel] <= num) {
                    sol[nivel] = c;
                    nivel = nivel + 1;
                    SumaSubconjuntos(vector, num, sol, nivel, exito);
                    if (!exito) {
                        nivel = nivel - 1;
                        sol[nivel] = 0;
                    }
                }
                c++;
            }

        }
    }

    //BUSQUEDA BINARIA v2
    public static void subconjuntoSumaBack2(int[] vector, int num, int[] solucion, int nivel, int suma,
                                            Boolean exito) {
        if (nivel == vector.length) {
            if (suma == num) exito = true;
        } else {
            int c = 0;     // Candidatos: c=0 no añadir; c=1 añadir
            while (!exito && (c < 2)) {
                if (c == 0 || ((suma + vector[nivel]) <= num)) {
                    solucion[nivel] = c;
                    suma = suma + (vector[nivel] * c);
                    nivel = nivel + 1;
                    subconjuntoSumaBack2(vector, num, solucion, nivel, suma, exito);
                    if (!exito) {
                        nivel = nivel - 1;
                        solucion[nivel] = 0;
                        suma = suma - (vector[nivel] * c);
                    }
                }
                c++;
            }
        }
    }

    //ARBOL DE ESTADOS COMBINATORIO
    public static void SumaSubconjuntosCombinatorio(int[] vector, int num, int[] solucion, int id, int suma,
                                                    Boolean exito) {
        if (suma == num) exito = true;
        else {
            int c = id; // Candidatos: c = id..vector.length
            while (!exito && (c < vector.length)) {
                if ((suma + vector[c]) <= num) {
                    solucion[c] = 1;
                    suma = suma + (vector[c]);
                    c = c + 1;
                    SumaSubconjuntosCombinatorio(vector, num, solucion, c, suma, exito);
                    if (!exito) {
                        c = c - 1;
                        solucion[c] = 0;
                        suma = suma - (vector[c]);
                    }
                }
                c++;
            }
        }
    }

    //PROBLEMA DEL CABALLERO


    public static void Caballero ( int[][] tablero, int numMov, int x, int y, Boolean exito){
        if(numMov>tablero.length*tablero.length) exito=true;
        else{
            int k, u, v;
            int[] dx = {-1,-2,-2,-1, 1, 2, 2, 1};
            int[] dy = {-2,-1, 1, 2, 2, 1,-1,-2};
            k = 0;
            while ((!exito) && (k < 8)){
                u = x + dx[k];
                v = y + dy[k];
                if ((u >= 0) && (u < tablero.length) &&
                        (v >= 0) && (v < tablero.length) &&
                        (tablero[u][v] == 0) ) {
                    tablero[u][v] = numMov;
                    numMov++;
                    Caballero(tablero, numMov, u, v, exito);
                    if (!exito) {
                        tablero[u][v] = 0;
                        numMov--;
                    }
                }
                k = k + 1;
            }
        }
    }

    //PROBLEMA DE LAS 8 REINAS
    public static boolean aceptable(int[] damas, int fila, int c){
        boolean correcto = true; int i=0;
        while ((correcto) && (i<fila)) {
            correcto = (damas[i] != c) && (Math.abs(damas[i]-c) != Math.abs(i-fila));
            i++;
        }
        return correcto;
    }
    public static void reinas(int[] damas, int fila, Boolean exito){
        if (fila==damas.length) exito = true;
        else {
            int c = 0;
            while ((c < damas.length) && (!exito)) {
                if (aceptable(damas, fila, c)){
                    damas[fila] = c;
                    fila=fila + 1;
                    reinas(damas, fila, exito);
                    if (!exito) fila = fila -1;
                }
                c++;
            }
        }
    }
}

