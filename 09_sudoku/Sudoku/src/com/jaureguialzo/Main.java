package com.jaureguialzo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void visualizar(int[][] tablero) {

        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {

                if (tablero[i][j] != 0) {
                    System.out.format("%2d", tablero[i][j]);
                } else {
                    System.out.print(" .");
                }
            }
            System.out.println();
        }

    }


    public static boolean numeroValidoEnFila(int[][] tablero, int fila, int numero) {

        int i = 0;
        while (i < tablero[0].length && tablero[fila][i] != numero) {
            i++;
        }

        return !(i < tablero[0].length);
    }

    public static boolean numeroValidoEnColumna(int[][] tablero, int columna, int numero) {

        int i = 0;
        while (i < tablero.length && tablero[i][columna] != numero) {
            i++;
        }

        return !(i < tablero.length);
    }


    public static boolean numeroValidoEnMiniSudoku(int[][] tablero, int fila, int columna, int numero) {

        boolean encontrado = false;

        int fila_inicio = (fila / 3) * 3;
        int columna_inicio = (columna / 3) * 3;

        for (int i = fila_inicio; i < fila_inicio + 3; i++) {
            for (int j = columna_inicio; j < columna_inicio + 3; j++) {
                if (tablero[i][j] == numero) {
                    encontrado = true;
                }
            }
        }

        return !encontrado;
    }


    public static boolean terminado(int[][] tablero) {

        int filas = tablero.length;
        int columnas = tablero[0].length;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (tablero[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] tablero = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},

                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},

                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9},
        };

        String respuesta;
        do {
            visualizar(tablero);

            System.out.print("Fila: ");
            int fila = Integer.parseInt(br.readLine());
            System.out.print("Columna: ");
            int columna = Integer.parseInt(br.readLine());
            System.out.print("Número: ");
            int numero = Integer.parseInt(br.readLine());


            if (numeroValidoEnFila(tablero, fila, numero) &&
                    numeroValidoEnColumna(tablero, columna, numero) &&
                    numeroValidoEnMiniSudoku(tablero, fila, columna, numero)) {

                tablero[fila][columna] = numero;
                System.out.println(":)");
            } else {
                System.out.println("¡Error!");
            }

            System.out.print("Pulsa ENTER para continuar o escribe FIN para terminar: ");
            respuesta = br.readLine();

        } while (!terminado(tablero) && !respuesta.equalsIgnoreCase("FIN"));

        if (terminado(tablero)) {
            System.out.println("¡Enhorabuena!");
        } else {
            System.out.println(":(");
        }

    }
}
