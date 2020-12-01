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

    public static int suma (int[] solucion, int[] vector, int nivel){
        int suma=0;
        for (int i=0; i<nivel; i++)
            if (solucion[i]==1) suma = suma+vector[i];
        return suma;
    }
    //arbol de busqueda binario
    public static void SumaSubconjuntos(int[] vector, int num, int[] sol, int nivel, Boolean exito) {
        if (nivel == vector.length) {
            if (suma(sol, vector, nivel )== num) exito=true;
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
}

